package com.techelevator;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.space.Space;
import com.techelevator.utility.TypeConverter;
import com.techelevator.venue.Venue;
import com.techelevator.view.Menu;
import com.techelevator.view.ReservationInput;

public class ExcelsiorCLI {

	private static final String MAIN_MENU_QUIT = "Quit";
	private static final String RETURN_TO_PREVIOUS = "Return to Previous Screen";
	private static final String MAIN_MENU_LIST_VENUES = "List Venues";
	private static final String MAIN_MENU_PROMPT = "What would you like to do?";
	private static final String[] MAIN_MENU_INT_OPTIONS = new String[] { MAIN_MENU_LIST_VENUES };
	private static final String[] MAIN_MENU_CHAR_OPTIONS = new String[] { MAIN_MENU_QUIT };
	private static final String[] SUB_MENU_CHAR_OPTIONS = new String[] { RETURN_TO_PREVIOUS };
	private static final String VIEW_VENUES_PROMPT = "Which venue would you like to view?";
	private static final String SUB_MENU_PROMPT = "What would you like to do next?";
	private static final String RESERVATION_MENU_SPACE_PROMPT = "Which space would you like to reserve (enter 0 to cancel)? ";
	private static final String RESERVATION_MENU_RESERVE_FOR_PROMPT = "Who is this reservation for? ";
	private static final String VENUE_VIEW_SPACES = "View Spaces";
	private static final String RESERVE_SPACE = "Reserve a Space";
	private static final String[] VENUE_DETAILS_INT_OPTIONS = new String[] { VENUE_VIEW_SPACES };
	private static final String[] SUB_MENU_RESERVE_SPACE = new String[] { RESERVE_SPACE };
	private static final String RESERVATION_PROMPT_DATE = "When do you need the space? (MM/DD/YYYY) ";
	private static final String RESERVATION_PROMPT_DAYS = "How many days will you need the space? ";
	private static final String RESERVATION_PROMPT_ATTENDEES = "How many people will be in attendance? ";
	private static final String GOODBYE = "Goodbye!";
	
	private static final String MAIN_MENU = "MAIN_MENU";
	private static final String VENUE_MENU = "VENUE_MENU";
	private static final String VENUE_DETAILS_MENU = "VENUE_DETAILS_MENU";
	private static final String SPACES_MENU = "SPACES_MENU";
	private static final String RESERVATION_SEARCH_MENU = "RESERVATION_SEARCH_MENU";
	private static final String RESERVATION_MENU = "RESERVATION_MENU";

	private ReservationInput ri;
	private Menu menu;
	private Concierge concierge;
	private String runningMenuName;

	public static void main(String[] args) {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/excelsior-venues");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");

		TypeConverter tc = new TypeConverter();
		ReservationInput ri = new ReservationInput(tc);
		Menu menu = new Menu(tc);
		String runningMenuName = MAIN_MENU;
		Concierge concierge = new Concierge(dataSource);
		ExcelsiorCLI application = new ExcelsiorCLI(menu, concierge, ri, runningMenuName);
		application.run();
	}

	public ExcelsiorCLI(Menu menu, Concierge concierge, ReservationInput ri, String runningMenuName) {
		this.menu = menu;
		this.concierge = concierge;
		this.ri = ri;
		this.runningMenuName = runningMenuName;
	}

	public void run() {
		while (runningMenuName.equals(MAIN_MENU)) {
			menu.displayUserPrompt(MAIN_MENU_PROMPT);
			menu.displayUserOptions(MAIN_MENU_INT_OPTIONS, MAIN_MENU_CHAR_OPTIONS);
			String mainMenuUserSelection = menu.getSelectionFromUser(MAIN_MENU_INT_OPTIONS, MAIN_MENU_CHAR_OPTIONS);
			runningMenuName = VENUE_MENU;
			if (mainMenuUserSelection.equals(MAIN_MENU_LIST_VENUES)) {
				while (runningMenuName.equals(VENUE_MENU)) {
					runningMenuName = runVenuesMenu();
				}
			} else if (mainMenuUserSelection.equals(MAIN_MENU_QUIT)) {
				menu.displayUserMessage(GOODBYE);
				break;
			} 
		}
	}
	
	public String runVenuesMenu() {
		String venueMenuUserSelection = viewVenuesMenu();
		if (venueMenuUserSelection.equals(RETURN_TO_PREVIOUS)) {
			return MAIN_MENU;
		} else {
			Venue chosenVenue = concierge.getVenueByName(venueMenuUserSelection);
			String venueCategories = concierge.getCategories(venueMenuUserSelection);
			runningMenuName = VENUE_DETAILS_MENU;
			while (runningMenuName.equals(VENUE_DETAILS_MENU)) {
				runningMenuName = runVenueDetailsMenu(chosenVenue, venueCategories);
			}
			return runningMenuName;
		}
	}
	
	public String runVenueDetailsMenu(Venue venue, String venueCategories) {
		String spaceChoiceUserSelection = viewVenueDetailsMenu(venue, venueCategories);
		runningMenuName = SPACES_MENU;
		while (runningMenuName.equals(SPACES_MENU)) {
			if (spaceChoiceUserSelection.equals(VENUE_VIEW_SPACES)) {
				String venueName = venue.getName();
				runningMenuName = runSpacesMenu(venueName, concierge.getAllSpacesByVenueName(venueName));
			} else if (spaceChoiceUserSelection.equals(RETURN_TO_PREVIOUS)) {
				return VENUE_MENU;
			}
		}
		return runningMenuName;
	}
	
	public String runSpacesMenu(String venueName, List<Space> spaces) {
		String spaceReserveUserSelection = viewSpacesMenu(venueName, spaces);
		runningMenuName = RESERVATION_SEARCH_MENU;
		if (spaceReserveUserSelection.equals(RESERVE_SPACE)) {
			while (runningMenuName.equals(RESERVATION_SEARCH_MENU)) {
				runningMenuName = runReservationSearchMenu(venueName);
			}
		} else if (spaceReserveUserSelection.equals(RETURN_TO_PREVIOUS)) {
			return VENUE_DETAILS_MENU;
		}
		return runningMenuName;
	}
	
	public String runReservationSearchMenu(String venueName) {
		LocalDate reservationDate = promptUserForStartDate();
		int reservationDays = promptUserForReservationDays();
		int reservationAttendees = promptUserForReservationAttendees();

		runningMenuName = RESERVATION_MENU;
		while (runningMenuName.equals(RESERVATION_MENU)) {
			runningMenuName = runReservationMenu(reservationDate, reservationDays, venueName, reservationAttendees);
		}
		return runningMenuName;
	}
	
	public String runReservationMenu(LocalDate reservationDate, int reservationDays, String venueName, int reservationAttendees) {

		LocalDate endDate = ri.getEndDate(reservationDate, reservationDays);
		Map<Long, Space> availableSpaces = concierge.getAvailableSpaces(venueName, reservationAttendees, endDate, reservationDate);
		
		runningMenuName = checkReservationAvailability(availableSpaces);
		if (!runningMenuName.equals(RESERVATION_MENU)) {
			return runningMenuName;
		}
		
		long spaceIDToReserve = promptForDesiredReservationSpace(availableSpaces, reservationDays);
		if (spaceIDToReserve == 0) {
			return SPACES_MENU;
		}
		
		String reservedFor = promptForPartyName();
		
		Space chosenSpace = availableSpaces.get(spaceIDToReserve);
		completeReservation(chosenSpace, venueName, reservationAttendees, reservationDate, endDate, reservedFor);

		return MAIN_MENU;
	}

	public String viewVenuesMenu() {
		menu.displayUserPrompt(VIEW_VENUES_PROMPT);
		String[] allVenueNames = menu.getTypeConverter().stringListToArray(concierge.getAllVenueNames());
		menu.displayUserOptions(allVenueNames, SUB_MENU_CHAR_OPTIONS);
		String venueMenuUserSelection = menu.getSelectionFromUser(allVenueNames, SUB_MENU_CHAR_OPTIONS);
		return venueMenuUserSelection;
	}
	
	public String viewVenueDetailsMenu(Venue venue, String venueCategories) {
		menu.displayVenueDetails(venue, venueCategories);
		menu.displayUserPrompt(SUB_MENU_PROMPT);
		menu.displayUserOptions(VENUE_DETAILS_INT_OPTIONS, SUB_MENU_CHAR_OPTIONS);
		String spaceChoiceUserSelection = menu.getSelectionFromUser(VENUE_DETAILS_INT_OPTIONS, SUB_MENU_CHAR_OPTIONS);
		return spaceChoiceUserSelection;
	}

	public String viewSpacesMenu(String venueName, List<Space> spaces) {
		menu.displayVenueSpaces(venueName, spaces);
		menu.displayUserPrompt(SUB_MENU_PROMPT);
		menu.displayUserOptions(SUB_MENU_RESERVE_SPACE, SUB_MENU_CHAR_OPTIONS);
		String spaceReserveUserSelection = menu.getSelectionFromUser(SUB_MENU_RESERVE_SPACE, SUB_MENU_CHAR_OPTIONS);
		return spaceReserveUserSelection;
	}
	
	public String checkReservationAvailability(Map<Long, Space> availableSpaces) {
		if (availableSpaces.size() < 1) {
			menu.displayNoAvailableSpaces();
			String retryInput = ri.getStringFromUser();
			if (retryInput.toUpperCase().equals("Y")) {
				return RESERVATION_SEARCH_MENU;
			} else {
				return VENUE_MENU;
			}
		}
		return RESERVATION_MENU;
	}
	
	public long promptForDesiredReservationSpace(Map<Long, Space> availableSpaces, int reservationDays) {
		menu.displayAvailableSpaces(availableSpaces, reservationDays);
		long spaceIDToReserve = -1;
		while (spaceIDToReserve == -1) {
			menu.displayUserPrompt(RESERVATION_MENU_SPACE_PROMPT);
			spaceIDToReserve = ri.getKeyFromUser(availableSpaces);
			if (spaceIDToReserve == 0) {
				return 0;
			} else if (!availableSpaces.containsKey(spaceIDToReserve)) {
				spaceIDToReserve = -1;
			}
		}
		return spaceIDToReserve;
	}
	
	public String promptForPartyName() {
		String reservedFor = "";
		while (reservedFor.equals("")) {
			menu.displayUserPrompt(RESERVATION_MENU_RESERVE_FOR_PROMPT);
			reservedFor = ri.getStringFromUser();
		}
		
		return reservedFor;
	}
	
	public void completeReservation(Space chosenSpace, String venueName, int reservationAttendees, LocalDate reservationDate, LocalDate endDate, String reservedFor) {
		long reservationID = concierge.makeReservation(chosenSpace.getSpaceID(), reservationAttendees, reservationDate, endDate, reservedFor);
		menu.displayConfirmationDetails(reservationID, venueName, chosenSpace.getSpaceName(), reservedFor, reservationAttendees, reservationDate, endDate, chosenSpace.getDailyRate());
	}
	
	public LocalDate promptUserForStartDate() {
		LocalDate reservationDate = null;
		while (reservationDate == null) {
			menu.displayUserPrompt(RESERVATION_PROMPT_DATE);
			reservationDate = ri.checkDateFromString();
		}
		return reservationDate;
	}
	
	public int promptUserForReservationDays() {
		int reservationDays = -1;
		while (reservationDays <= 0) {
			menu.displayUserPrompt(RESERVATION_PROMPT_DAYS);
			reservationDays = ri.checkInt();
		}
		return reservationDays;
	}
	
	public int promptUserForReservationAttendees() {
		int reservationAttendees = -1;
		while (reservationAttendees <= 0) {
			menu.displayUserPrompt(RESERVATION_PROMPT_ATTENDEES);
			reservationAttendees = ri.checkInt();
		}
		return reservationAttendees;
	}
}