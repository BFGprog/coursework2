package ru.skypro.hw.coursework.coursework2.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import ru.skypro.hw.coursework.coursework2.domain.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();


    @PostConstruct
    public void init(){
        add("Какие условные операторы вы знаете? Дайте краткое определение каждому из них.", 
                "if или же if-else, а также switch" +
                "оператор if-else состоит из трех частей: условие, команда 1 и команда 2. Условие представляет из себя булевое выражение, если оно верно выполняется команда 1, иначе команда 2. " +
                "switch состоит из case, breake и default. switch принимает на вход значение, которое соответствует кейсу, код в указанном кейсе начнет выполнение, пока не встретит breake, если ни один из кейсов не будет соответствовать значению, будет вызван блок default.");
        add("Какие циклы вы знаете, в чем их отличия?", 
                "Циклы for, while, do-while" +
                "Цикл for состоит из переменной, условия, выражения и тела цикла. " +
                "Отличается возможностью инициализации переменной для использования как счетчика." +
                "Цикл while состоит из условия и тела цикла. " +
                "Цикл do-while состоит из условия и тела цикла. Выполняется минимум один раз");
        add("Методы каких типов бывают? Приведите примеры использования каждого типа.", 
                "Методы представляют из себя блок кода, который запрограммирован на определенную функцию. " +
                "Сами методы можно разделить на статические и не статические, а также их подразделы, методы которые возвращают значение и методы типа void, которые этого не делают." +
                "Статические методы принадлежат классу и могут быть вызваны без создания объекта класса, как пример это может быть метод calculateSum(), который принимает на вход переменные и возвращает их сумму." +
                "Не статические методы находятся в классах но принадлежат объекту и для их использования необходимо создать экземпляр класса, к примеру существует класс Person и у него есть метод setAge(), функция этого метода изменять возраст при его вызове, этот метод не может быть использована без создания экземпляра класса Person");
        add("Расскажите о переменных примитивного и ссылочного типа. В чём различия данных переменных?", 
                "Примитивными переменными являются целочисленные, с плавающей точкой, символьный и логический, остальные являются ссылочного типа, такие как строка, массив или поля класса." +
                "Для примитивных переменных память выделяется в стеке и ограничена типом переменной, для ссылочных память выделяется в heap, так как заранее неизвестно какого размера будет переменная, а непосредственно в переменную кладется ссылка на эту область памяти." + "\n");
        add("Что такое «переменная»?", 
                "Переменной является ячейка памяти, в которой можно хранить примитивный или ссылочный тип данных. Примитивными является целочисленные, с плавающей точкой, символьный, логический, остальные являются ссылочными, такие как строка, массив или объект класса");
        add("По каким параметрам переменные различаются?", 
                "Переменные различаются их объявлением. Для примитивов это целочисленные byte, int, для чисел с плавающей точкой это float и double, символьный - char и логический boolean. Для ссылочных это String, элемент массива, или свойство объекта класса");
        add("Что означает \"инициализация\"?",
                "Под инициализацией подразумевается присвоение значения объявленной переменной");
        add("Что такое «цикл»?", 
                "Многократное выполнение определенного кода. Итерации цикла будут продолжаться, пока выполняется условие");
    }

    @Override
    public int getSize(){
        return questions.size();
    }

    @Override
    public Question add(String question, String answer) {
        Question addQuestion = new Question(question, answer);
        questions.add(addQuestion);
        return addQuestion;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        Question removeQuestion = new Question(question, answer);
        if (!questions.contains(removeQuestion)){
            throw new IllegalArgumentException();
        }
        questions.remove(removeQuestion);
        return removeQuestion;
    }

    @Override
    public Collection<Question> getAll() {
        return new ArrayList<>(questions);
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        List<Question> question = new ArrayList<>(questions);
        return question.get(random.nextInt(questions.size()));
    }

}
