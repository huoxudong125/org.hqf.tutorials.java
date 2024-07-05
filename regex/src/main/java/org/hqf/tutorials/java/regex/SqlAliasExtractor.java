package org.hqf.tutorials.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class SqlAliasExtractor {

    public static class TableAlias {
        private String tableName;
        private String alias;

        public TableAlias(String tableName, String alias) {
            this.tableName = tableName;
            this.alias = alias;
        }

        @Override
        public String toString() {
            return "Table: " + tableName + ", Alias: " + alias;
        }
    }

    public static List<TableAlias> extractTableAliases(String sql) {
        List<TableAlias> tableAliases = new ArrayList<>();

        // 正则表达式模式
//        String pattern = "\\b(?:FROM|JOIN)\\b\\s+(\\w+\\.\\w+)\\s+(?:AS\\s+)?(\\w+)";
        String pattern = "\\b(?:FROM|JOIN)\\b\\s+([\\w|.]+)\\s+(?:AS\\s+)?(\\w+)";
        Pattern compiledPattern = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = compiledPattern.matcher(sql);

        // 查找匹配
        while (matcher.find()) {
            String tableName = matcher.group(1);
            String alias = matcher.group(2);
            tableAliases.add(new TableAlias(tableName, alias));
        }
        return tableAliases;
    }

    public static void main(String[] args) {
        // 示例SQL语句
        String[] sqlStatements = {
                "FROM uorders.requireapply T0\n" +
                        "INNER JOIN uorders.requireapplyitem AS T3 ON T3.require_apply_id = T0.id\n" +
                        "LEFT JOIN uorders.requireapplyitem_character_1 AS T4 ON T4.id = T3.crequireapplyitemcharacter\n" +
                        "LEFT JOIN uorders.requireapply_character_1 AS T1 ON T1.id = T0.crequireapplycharacter",
                "SELECT * FROM employees AS e",
                "SELECT e.name FROM employees e",
                "SELECT d.name FROM departments d WHERE d.id = 1"
        };

        // 提取别名
        for (String sql : sqlStatements) {
            // 提取表和别名
            List<TableAlias> tableAliases = extractTableAliases(sql);
            for (TableAlias tableAlias : tableAliases) {
                System.out.println(tableAlias);
            }
        }


    }
}