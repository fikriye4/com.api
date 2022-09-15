package test_data;

import java.util.HashMap;
import java.util.Map;

    public class AutomationExerciseTestData {

        public Map<String, String> dataKeyMap(String name, String email, String title) {
            Map<String, String> dataKeyMap = new HashMap<>();
            dataKeyMap.put("name", name);
            dataKeyMap.put("email", email);
            dataKeyMap.put("title", title);

            return dataKeyMap;
        }

        public Map<String, Object> expectedDateMap(Object responseCode, Map<String, String> user) {

            Map<String, Object> expectedDate = new HashMap<>();
            expectedDate.put("responseCode", responseCode);
            expectedDate.put("user", user);

            return expectedDate;
        }

    }

