/**
 *
 * @param {String} input Space delimited string of numbers
 */
function iqTest(input) {
  const digits = input.split(' ');
  const numbers = digits.map((d) => parseInt(d));

  const evens = numbers.filter((n) => n % 2 === 0).length;
  const odds = numbers.filter((n) => n % 2 === 1).length;

  if (odds === 1) {
    return numbers.findIndex((n) => n % 2 === 1) + 1;
  } else if (evens === 1) {
    return numbers.findIndex((n) => n % 2 === 0) + 1;
  } else {
    return 0;
  }
}

/**
 * Title cases a list of strings.
 * @param {String} title String to convert
 * @param {String} exceptionWords Space delimited words to ignore
 */
function titleCase(title, exceptionWords) {
  const exceptions = exceptionWords === undefined ? [] : exceptionWords.toLowerCase().split(' ');
  let words = title.toLowerCase().split(' ');

  for (let i = 0; i < words.length; i++) {
    if (!exceptions.includes(words[i]) || i === 0) {
      words[i] = words[i].charAt(0).toUpperCase() + words[i].slice(1);
    }
  }

  return words.join(' ');
}
