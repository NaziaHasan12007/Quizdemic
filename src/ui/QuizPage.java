package ui;

import model.*;
import io.ResultManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Enumeration;

public class QuizPage extends BaseFrame {
    private QuizSession session;
    private int currentIndex = 0;
    private JTextArea questionArea;
    private JLabel timerLabel;
    private ButtonGroup optionGroup;
    private JPanel optionsPanel;
    private JButton nextButton, backButton, submitButton;
    private Timer timer;
    private int timeLeft = 15 * 60;

    public QuizPage(QuizSession session) {
        super("Quiz - " + session.getSubject());
        this.session = session;

        // ========== Timer ==========
        timerLabel = new JLabel("Time Left: 15:00");
        timerLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        timerLabel.setForeground(Color.RED);
        GridBagConstraints gbc = defaultConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(timerLabel, gbc);

        // ========== Question ==========
    /*  questionArea = new JTextArea();
        questionArea.setFont(new Font("Segoe UI", Font.BOLD, 20));
        questionArea.setLineWrap(true);
        questionArea.setWrapStyleWord(true);
        questionArea.setEditable(false);
        questionArea.setOpaque(false);
        questionArea.setFocusable(false);
        questionArea.setPreferredSize(new Dimension(800, 100));

        gbc = defaultConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        mainPanel.add(questionArea, gbc);
    */
        questionArea = new JTextArea();
        questionArea.setFont(new Font("Segoe UI", Font.BOLD, 20));
        questionArea.setLineWrap(true);
        questionArea.setWrapStyleWord(true);
        questionArea.setEditable(false);
        questionArea.setOpaque(false);
        questionArea.setFocusable(false);

        // Wrap in scroll pane
        JScrollPane questionScroll = new JScrollPane(questionArea);
        questionScroll.setPreferredSize(new Dimension(800, 150));
        questionScroll.setBorder(null);
        questionScroll.setOpaque(false);
        questionScroll.getViewport().setOpaque(false);
        questionScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        questionScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Add to layout
        gbc = defaultConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 0.1;  // give some height space to the question area
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(questionScroll, gbc);

        // ========== Options ==========
        optionsPanel = new JPanel();
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
        optionsPanel.setOpaque(false);

        JScrollPane scrollPane = new JScrollPane(optionsPanel);
        scrollPane.setPreferredSize(new Dimension(800, 300));
        scrollPane.setBorder(null);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        gbc = defaultConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        mainPanel.add(scrollPane, gbc);

        // ========== Buttons ==========
        nextButton = createButton("Next");
        backButton = createButton("Back");
        submitButton = createButton("Submit");

        backButton.addActionListener(e -> {
            if (currentIndex > 0) {
                currentIndex--;
                session.removeLastAnswer();
                showQuestion();
            }
        });

        nextButton.addActionListener(this::handleNext);

        submitButton.addActionListener(e -> endSession());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
        buttonPanel.setOpaque(false);
        buttonPanel.add(backButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(submitButton);

        gbc = defaultConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        mainPanel.add(buttonPanel, gbc);

        // ========== Timer Start ==========
        timer = new Timer(1000, e -> {
            timeLeft--;
            int minutes = timeLeft / 60;
            int seconds = timeLeft % 60;
            timerLabel.setText(String.format("Time Left: %02d:%02d", minutes, seconds));
            if (timeLeft <= 0) {
                timer.stop();
                endSession();
            }
        });
        timer.start();

        showQuestion();
        setVisible(true);
    }

    private void showQuestion() {
        optionGroup = new ButtonGroup();
        optionsPanel.removeAll();

        Question q = session.getQuestions().get(currentIndex);
        questionArea.setText("Q" + (currentIndex + 1) + ": " + q.getQuestionText());

        if (q instanceof MultipleChoiceQuestion mcq) {
            for (String opt : mcq.getOptions()) {
                JRadioButton btn = new JRadioButton(opt);
                btn.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                btn.setOpaque(false);
                optionGroup.add(btn);
                optionsPanel.add(btn);
                optionsPanel.add(Box.createVerticalStrut(8));
            }
        } else if (q instanceof TrueFalseQuestion) {
            for (String opt : new String[]{"True", "False"}) {
                JRadioButton btn = new JRadioButton(opt);
                btn.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                btn.setOpaque(false);
                optionGroup.add(btn);
                optionsPanel.add(btn);
                optionsPanel.add(Box.createVerticalStrut(8));
            }
        }

        optionsPanel.revalidate();
        optionsPanel.repaint();
    }

    private void handleNext(ActionEvent e) {
        String selected = null;
        for (Enumeration<AbstractButton> buttons = optionGroup.getElements(); buttons.hasMoreElements(); ) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                selected = button.getText();
                break;
            }
        }

        session.addAnswer(selected);
        currentIndex++;

        if (currentIndex < session.getQuestions().size()) {
            showQuestion();
        } else {
            endSession();
        }
    }

    private void endSession() {
        timer.stop();
        session.endSession();
        ResultManager.saveResult(session);

        new QuizResultPage(session).setVisible(true);
        dispose();
    }
}
