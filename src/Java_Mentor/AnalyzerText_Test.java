package Java_Mentor;

//3.5.7
public class AnalyzerText_Test extends RuntimeException {
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
    abstract public class KeywordAnalyzer implements TextAnalyzer {
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
    public class SpamAnalyzer extends KeywordAnalyzer {
        private String[] keywords;

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
    public class NegativeTextAnalyzer extends KeywordAnalyzer {
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
    public class TooLongTextAnalyzer implements TextAnalyzer {
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

    //    Анализатор текста
    interface TextAnalyzer {
        Label processText(String text);
    }

    //метка
    enum Label {
        SPAM, NEGATIVE_TEXT, TOO_LONG, OK
    }
}



