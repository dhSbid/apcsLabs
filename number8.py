def capFirstWord(sentence):

  sList = sentence.split(". ")
  for i in sList:
    sList[i][0] = sList[i][0].toUpper()
  newString = sList.join();
  return newString

capFirstWord("hello. i am. bye. now for real.")
