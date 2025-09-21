//Abstract Factory Pattern
//Topic: Creating families of UI Components (Button + Checkbox) for different Operating Systems.
// Abstract products
interface Button {
    void paint();
}

interface Checkbox {
    void paint();
}

// Concrete products (Windows)
class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("Rendering a Windows-style button");
    }
}

class WindowsCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Rendering a Windows-style checkbox");
    }
}

// Concrete products (Mac)
class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("Rendering a MacOS-style button");
    }
}

class MacCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Rendering a MacOS-style checkbox");
    }
}

// Abstract Factory
interface UIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete factories
class WindowsFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

// Client
public class AbstractFactoryDemo {
    private final Button button;
    private final Checkbox checkbox;

    public AbstractFactoryDemo(UIFactory factory) {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }

    public void render() {
        button.paint();
        checkbox.paint();
    }

    public static void main(String[] args) {
        UIFactory windowsFactory = new WindowsFactory();
        AbstractFactoryDemo windowsApp = new AbstractFactoryDemo(windowsFactory);
        windowsApp.render();

        UIFactory macFactory = new MacFactory();
        AbstractFactoryDemo macApp = new AbstractFactoryDemo(macFactory);
        macApp.render();
    }
}
//Here:
//UIFactory is the Abstract Factory.
//WindowsFactory and MacFactory are Concrete Factories.
//Button + Checkbox families are created consistently depending on the platform.