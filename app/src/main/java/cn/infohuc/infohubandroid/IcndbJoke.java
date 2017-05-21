package cn.infohuc.infohubandroid;

/**
 * @author toctrash on 21/05/2017.
 */

class IcndbJoke {
    private String type;
    private Joke value;
    public String getType() {
        return type;
    }

    public Joke getValue() {
        return value;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(Joke value) {
        this.value = value;
    }

    String getJoke(){
        return value.getJoke();
    }

    private static class Joke {
        private int id;
        private String joke;
        private String[] categories;

        public int getId() {
            return id;
        }

        String getJoke() {
            return joke;
        }

        public String[] getCategories() {
            return categories;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setJoke(String joke) {
            this.joke = joke;
        }

        public void setCategories(String[] categories) {
            this.categories = categories;
        }
    }
}
