package Java_Mentor;

public class SpamAnalyzerNegative {
    // 3.5.7
//метод Label
    public Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer analyzer : analyzers) {
            if (analyzer.processText(text) != Label.OK) {
                return analyzer.processText(text);
            }
        }
        return Label.OK;
    }

    //    Анализатор ключевых слов
//    Логику абстрагируем в абстрактный класс KeywordAnalyzer следующим образом:
//    Выделим два абстрактных метода getKeywords и getLabel
    abstract public static class KeywordAnalyzer implements TextAnalyzer {
        //        Выделим два абстрактных метода getKeywords и getLabel,
//        один из которых будет возвращать набор ключевых слов,
//        а второй метку, которой необходимо пометить положительные срабатывания.
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

    //Анализатор спама - 1
//Сделаем SpamAnalyzer и NegativeTextAnalyzer наследниками KeywordAnalyzer и реализуем абстрактные методы.
//SpamAnalyzer и NegativeTextAnalyzer во многом похожи
    public static class SpamAnalyzer extends KeywordAnalyzer {
        private final String[] keywords;

        public SpamAnalyzer(String[] keywords) {
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

    //Анализатор негативного текста - 2
//Сделаем SpamAnalyzer и NegativeTextAnalyzer наследниками KeywordAnalyzer и реализуем абстрактные методы.
//SpamAnalyzer и NegativeTextAnalyzer во многом похожи
    public static class NegativeTextAnalyzer extends KeywordAnalyzer {
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

    //Анализатор слишком длинного текста - 3
//TooLongTextAnalyzer должен конструироваться от int-а с максимальной допустимой длиной комментария.
// Объект этого класса должен сохранять в своем состоянии это число в приватном поле maxLength.
    public static class TooLongTextAnalyzer implements TextAnalyzer {
        private final int MAX_LENGTH;

        public TooLongTextAnalyzer(int threshold) {
            this.MAX_LENGTH = threshold;
        }

        @Override
        public Label processText(String text) {
            if (text.length() > MAX_LENGTH) {
                return Label.TOO_LONG;
            } else {
                return Label.OK;
            }
        }
    }

    //Анализатор текста - Вы решили абстрагировать фильтр в виде следующего интерфейса:
    public interface TextAnalyzer {
        Label processText(String text);
    }

    //метка Label – тип-перечисление, которые содержит метки, которыми будем помечать текст:
    enum Label {
        SPAM, NEGATIVE_TEXT, TOO_LONG, OK
    }

    //-//-//    //-//-//    //-//-//
//-//-//    //-//-//    //-//-//
    public static void main(String[] args) {
//тесты
// инициализация анализаторов для проверки в порядке данного набора анализаторов
        String[] spamKeywords = {"spam", "bad"};
        int commentMaxLength = 40;
        TextAnalyzer[] textAnalyzers1 = {
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(commentMaxLength)
        };
        TextAnalyzer[] textAnalyzers2 = {
                new SpamAnalyzer(spamKeywords),
                new TooLongTextAnalyzer(commentMaxLength),
                new NegativeTextAnalyzer()
        };
        TextAnalyzer[] textAnalyzers3 = {
                new TooLongTextAnalyzer(commentMaxLength),
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer()
        };
        TextAnalyzer[] textAnalyzers4 = {
                new TooLongTextAnalyzer(commentMaxLength),
                new NegativeTextAnalyzer(),
                new SpamAnalyzer(spamKeywords)
        };
        TextAnalyzer[] textAnalyzers5 = {
                new NegativeTextAnalyzer(),
                new SpamAnalyzer(spamKeywords),
                new TooLongTextAnalyzer(commentMaxLength)
        };
        TextAnalyzer[] textAnalyzers6 = {
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(commentMaxLength),
                new SpamAnalyzer(spamKeywords)
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
        TextAnalyzer[][] textAnalyzers = {textAnalyzers1, textAnalyzers2, textAnalyzers3,
                textAnalyzers4, textAnalyzers5, textAnalyzers6};
        SpamAnalyzerNegative testObject = new SpamAnalyzerNegative();
        int numberOfAnalyzer; // номер анализатора, указанный в идентификаторе textAnalyzers{№}
        int numberOfTest = 0; // номер теста, который соответствует индексу тестовых комментариев
        for (String test : tests) {
            numberOfAnalyzer = 1;
            System.out.print("test #" + numberOfTest + ": ");
            System.out.println(test);
            for (TextAnalyzer[] analyzers : textAnalyzers) {
                System.out.print(numberOfAnalyzer + ": ");
                System.out.println(testObject.checkLabels(analyzers, test));
                numberOfAnalyzer++;
            }
            numberOfTest++;
        }
    }
}

