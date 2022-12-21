package config;

public class APIConstants {
    public static class Items {
        public static final String BASE_URL = "https://todo.ly/api";
    }

    public static class ItemsEndpoints {

        public static final String itemPost = "/items.json";

        public static String itemsGet(int id) {
            return "/items/" + id + ".json";
        }

        public static String itemsPut(int id) {
            return "/items/" + id + ".json";
        }

        public static String itemsDelete(int id) {
            return "/items/" + id + ".json";
        }
    }
}
