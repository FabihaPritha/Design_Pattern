//.....BuilderPattern Pattern.....
//Purpose: Build complex objects step-by-step.
//
//Use Case:
// When constructing an object requires many steps or options.

//Real-life Example:
//Making a burger: choose bun, add sauce, add meat, etc.


package patterns.Creational_Design_Pattern;


class Burger {
    private String bun;
    private String sauce;
    private String meat;

    private Burger(Builder builder) {
        this.bun = builder.bun;
        this.sauce = builder.sauce;
        this.meat = builder.meat;
    }

    public void show() {
        System.out.println("Burger with " + bun + ", " + sauce + ", " + meat);
    }

    static class Builder {
        private String bun;
        private String sauce;
        private String meat;

        public Builder setBun(String bun) {
            this.bun = bun;
            return this;
        }

        public Builder setSauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public Builder setMeat(String meat) {
            this.meat = meat;
            return this;
        }

        public Burger build() {
            return new Burger(this);
        }
    }
}

public class BuilderPattern {
    public static void main(String[] args) {
        Burger myBurger = new Burger.Builder()
                .setBun("Sesame")
                .setSauce("Mayo")
                .setMeat("Beef")
                .build();
        myBurger.show();
    }
}

