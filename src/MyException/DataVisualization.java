package MyException;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class DataVisualization extends JFrame {
    private Map<String, Integer> data;

    public DataVisualization() {
        setTitle("数据统计");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        data = new HashMap<>();
        data.put("项目1", 10);
        data.put("项目2", 20);
        data.put("项目3", 30);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(createBarChartPanel(), BorderLayout.CENTER);
        add(panel);
    }

    private JPanel createBarChartPanel() {
        JPanel chartPanel = new JPanel();
        chartPanel.setLayout(new GridLayout(1, 1));

        DefaultListModel<String> listModel = new DefaultListModel<>();
        data.forEach((key, value) -> listModel.addElement(key));

        JList<String> dataList = new JList<>(listModel);
        dataList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        chartPanel.add(dataList);

        JPanel chartArea = new JPanel();
        chartArea.setLayout(new BorderLayout());
        chartArea.add(new JLabel("数据统计"), BorderLayout.NORTH);

        JPanel chart = new JPanel();
        chart.setLayout(new GridLayout(1, 1));
        chart.add(new ChartPanel());
        chartArea.add(chart, BorderLayout.CENTER);
        chartPanel.add(chartArea);

        return chartPanel;
    }

    private class ChartPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            int maxValue = data.values().stream().mapToInt(Integer::intValue).max().orElse(0);
            int width = getWidth();
            int height = getHeight();

            int barWidth = width / (2 * data.size());
            int x = 10;
            for (Map.Entry<String, Integer> entry : data.entrySet()) {
                int barHeight = (int) ((double) entry.getValue() / maxValue * height * 0.8);
                int y = height - barHeight;
                g2d.setColor(Color.BLUE);
                g2d.fillRect(x, y, barWidth, barHeight);
                g2d.setColor(Color.BLACK);
                g2d.drawRect(x, y, barWidth, barHeight);
                g2d.drawString(entry.getKey(), x + barWidth / 2 - 10, height - 5);
                x += 2 * barWidth;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DataVisualization visualization = new DataVisualization();
            visualization.setVisible(true);
        });
    }
}
