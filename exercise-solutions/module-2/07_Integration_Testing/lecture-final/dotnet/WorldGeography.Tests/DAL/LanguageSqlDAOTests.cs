using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Collections.Generic;
using System.Data.SqlClient;
using WorldGeography.DAL;
using WorldGeography.Models;
using WorldGeography.Tests.DAL;

namespace WorldGeography.Tests
{
    [TestClass]
    public class LanguageSqlDAOTests : WorldDAOTests
    {
        [DataTestMethod]
        [DataRow("USA", 1)]
        [DataRow("XYZ", 0)]
        public void GetLanguagesTest(string countryCode, int expectedCount)
        {
            // Arrange
            LanguageSqlDAO dal = new LanguageSqlDAO(ConnectionString);

            // Act
            IList<Language> languages = dal.GetLanguages(countryCode);

            // Assert
            Assert.AreEqual(expectedCount, languages.Count);
        }

        [TestMethod]
        public void AddLanguage()
        {
            // Arrange
            LanguageSqlDAO dal = new LanguageSqlDAO(ConnectionString);
            int initialRowCount = GetRowCount("countrylanguage");
            Language language = new Language()
            {
                CountryCode = "USA",
                Name = "English",
                IsOfficial = true,
                Percentage = 80
            };

            // Act
            dal.AddNewLanguage(language);

            // Assert
            int finalRowCount = GetRowCount("countrylanguage");
            Assert.AreEqual(initialRowCount + 1, finalRowCount);
        }

        [TestMethod]
        [ExpectedException(typeof(SqlException))]
        public void AddLanguage_FailsBecauseLanguageExists()
        {
            // Arrange
            LanguageSqlDAO dal = new LanguageSqlDAO(ConnectionString);
            Language language = new Language()
            {
                CountryCode = "USA",
                Name = "Test Language", //already exists
                IsOfficial = true,
                Percentage = 80
            };

            // Act
            dal.AddNewLanguage(language);
        }

        [TestMethod]
        public void RemoveLanguage()
        {
            // Arrange
            LanguageSqlDAO dal = new LanguageSqlDAO(ConnectionString);
            int initialRowCount = GetRowCount("countrylanguage");
            Language language = new Language()
            {
                CountryCode = "USA",
                Name = "Test Language",
                IsOfficial = true,
                Percentage = 80
            };

            // Act
            dal.RemoveLanguage(language);

            // Assert
            int finalRowCount = GetRowCount("countrylanguage");
            Assert.AreEqual(initialRowCount - 1, finalRowCount);
        }

    }
}
