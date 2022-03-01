package Stepic.exmpl.module2;

import Java_Mentor.SpamAnalyzerNegative;

public class Solution353_SPAM_Analyzer {
    public static void main(String[] args) {
//тесты
// инициализация анализаторов для проверки в порядке данного набора анализаторов

        String[] spamKeywords = {"spam", "bad"};
        int commentMaxLength = 40;
        SpamAnalyzerNegative.TextAnalyzer[] textAnalyzers1 = {
                new SpamAnalyzerNegative.SpamAnalyzer(spamKeywords),
                new SpamAnalyzerNegative.NegativeTextAnalyzer(),
                new SpamAnalyzerNegative.TooLongTextAnalyzer(commentMaxLength)
        };
        SpamAnalyzerNegative.TextAnalyzer[] textAnalyzers2 = {
                new SpamAnalyzerNegative.SpamAnalyzer(spamKeywords),
                new SpamAnalyzerNegative.TooLongTextAnalyzer(commentMaxLength),
                new SpamAnalyzerNegative.NegativeTextAnalyzer()
        };
        SpamAnalyzerNegative.TextAnalyzer[] textAnalyzers3 = {
                new SpamAnalyzerNegative.TooLongTextAnalyzer(commentMaxLength),
                new SpamAnalyzerNegative.SpamAnalyzer(spamKeywords),
                new SpamAnalyzerNegative.NegativeTextAnalyzer()
        };
        SpamAnalyzerNegative.TextAnalyzer[] textAnalyzers4 = {
                new SpamAnalyzerNegative.TooLongTextAnalyzer(commentMaxLength),
                new SpamAnalyzerNegative.NegativeTextAnalyzer(),
                new SpamAnalyzerNegative.SpamAnalyzer(spamKeywords)
        };
        SpamAnalyzerNegative.TextAnalyzer[] textAnalyzers5 = {
                new SpamAnalyzerNegative.NegativeTextAnalyzer(),
                new SpamAnalyzerNegative.SpamAnalyzer(spamKeywords),
                new SpamAnalyzerNegative.TooLongTextAnalyzer(commentMaxLength)
        };
        SpamAnalyzerNegative.TextAnalyzer[] textAnalyzers6 = {
                new SpamAnalyzerNegative.NegativeTextAnalyzer(),
                new SpamAnalyzerNegative.TooLongTextAnalyzer(commentMaxLength),
                new SpamAnalyzerNegative.SpamAnalyzer(spamKeywords)
        };
// тестовые комментарии
        String[] tests = new String[8];
        tests[0] = "This comment is so good.";                            // OK
        tests[1] = "This comment is so Loooooooooooooooooooooooooooong."; // TOO_LONG
        tests[2] = "Very negative comment !!!!=(!!!!;";                   // NEGATIVE_TEXT
        tests[3] = "Very BAAAAAAAAAAAAAAAAAAAAAAAAD comment with :|;";    // NEGATIVE_TEXT or TOO_LONG
        tests[4] = "This comment is so bad....";                          // SPAM
        tests[5] = "The comment is a spam, maybeeeeeeeeeeeeeeeeeeeeee!";  // SPAM or TOO_LONG
        tests[6] = "Negative bad :( spam.";                               // SPAM or NEGATIVE_TEXT
        tests[7] = "Very bad, very neg =(, very ..................";      // SPAM or NEGATIVE_TEXT or TOO_LONG
        SpamAnalyzerNegative.TextAnalyzer[][] textAnalyzers = {textAnalyzers1, textAnalyzers2, textAnalyzers3,
                textAnalyzers4, textAnalyzers5, textAnalyzers6};
        SpamAnalyzerNegative testObject = new SpamAnalyzerNegative();
        int numberOfAnalyzer; // номер анализатора, указанный в идентификаторе textAnalyzers{№}
        int numberOfTest = 0; // номер теста, который соответствует индексу тестовых комментариев
        for (String test : tests) {
            numberOfAnalyzer = 1;
            System.out.print("test #" + numberOfTest + ": ");
            System.out.println(test);
            for (SpamAnalyzerNegative.TextAnalyzer[] analyzers : textAnalyzers) {
                System.out.print(numberOfAnalyzer + ": ");
                System.out.println(testObject.checkLabels(analyzers, test));
                numberOfAnalyzer++;
            }
            numberOfTest++;
        }
    }

    public Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer analyzer : analyzers) {
            if (analyzer.processText(text) != Label.OK) {
                return analyzer.processText(text);
            }
        }
        return Label.OK;
    }

    abstract class KeywordAnalyzer implements TextAnalyzer {
        abstract protected String[] getKeywords();

        abstract protected Label getLabel();

        public Label processText(String text) {
            String[] keywords = getKeywords();
            for (String keyword : keywords) {
                if (text.contains(keyword)) {
                    return getLabel();
                }
            }
            return Label.OK;
        }
    }

    class SpamAnalyzer extends KeywordAnalyzer {
        private final String[] keywords;

        SpamAnalyzer(String[] keywords) {
            this.keywords = keywords;
        }

        @Override
        protected String[] getKeywords() {
            return keywords;
        }

        @Override
        protected Label getLabel() {
            return Label.SPAM;
        }

    }

    class NegativeTextAnalyzer extends KeywordAnalyzer {
        private final String[] KEYWORDS = {":(", "=(", ":|"};

        @Override
        protected String[] getKeywords() {
            return KEYWORDS;
        }

        @Override
        protected Label getLabel() {
            return Label.NEGATIVE_TEXT;
        }
    }

    public class TooLongTextAnalyzer implements TextAnalyzer {
        private final int maxLength;

        public TooLongTextAnalyzer(int maxLength) {
            this.maxLength = maxLength;
        }

        @Override
        public Label processText(String text) {
            if (text.length() > maxLength) {
                return Label.TOO_LONG;
            } else
                return Label.OK;
        }
    }

    interface TextAnalyzer {
        Label processText(String text);
    }

    enum Label {
        SPAM, NEGATIVE_TEXT, TOO_LONG, OK
    }
}
