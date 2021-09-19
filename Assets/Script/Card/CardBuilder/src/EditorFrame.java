import java.awt.event.*;
import java.io.File;

import javax.swing.*;


public class EditorFrame extends JFrame{
    JFrame frame;
    public void CreateFrame() {    
        frame = new JFrame("CardEditor");
        frame.setSize(300, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();    
        frame.add(panel);
        placeComponents(panel);
        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);
        JLabel TitleLabel = new JLabel("卡牌名称:");
        TitleLabel.setBounds(10,20,80,25);
        panel.add(TitleLabel);
        
        JTextField TitleText = new JTextField(20);
        TitleText.setBounds(100,20,165,25);
        panel.add(TitleText);

        JLabel typeLabel = new JLabel("卡牌类别:");
        typeLabel.setBounds(10,50,80,25);
        panel.add(typeLabel);

        JTextField typeText = new JTextField(20);
        typeText.setBounds(100,50,165,25);
        panel.add(typeText);

        JLabel damagLabel = new JLabel("伤害:");
        damagLabel.setBounds(10,80,80,25);
        panel.add(damagLabel);

        JTextField damageText = new JTextField(20);
        damageText.setBounds(100,80,165,25);
        panel.add(damageText);

        JLabel HealthLabel = new JLabel("生命值:");
        HealthLabel.setBounds(10,110,80,25);
        panel.add(HealthLabel);

        JTextField HealthText = new JTextField(20);
        HealthText.setBounds(100,110,165,25);
        panel.add(HealthText);

        JLabel FileLabel = new JLabel("立绘地址:");
        FileLabel.setBounds(10,140,80,25);
        panel.add(FileLabel);

        JButton FileButton = new JButton("选择文件");
        FileButton.setBounds(100,140,165,25);
        panel.add(FileButton);

        FileButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                showChooseDialog(frame,FileButton);
            }
        });

        JButton SummitButton = new JButton("确定");
        SummitButton.setBounds(10, 170, 80, 25);
        panel.add(SummitButton);

        SummitButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Card NewCard = new Card(TitleText.getText(), "测试用", typeText.getText(), FileButton.getText(), 
                Integer.parseInt(damageText.getText()), Integer.parseInt(HealthText.getText()));
                NewCard.Show();
                GraphicEditor editor = new GraphicEditor();
                String path = editor.CreateBackImage(NewCard,"src/backimg.png", "src/cardInstancePackage");
                System.out.println(path);
            }
        });
    }

    private void showChooseDialog(JFrame parent,JButton FileButton){
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setMultiSelectionEnabled(false);
        int result = chooser.showOpenDialog(parent);
        if (result == JFileChooser.APPROVE_OPTION){
            File file = chooser.getSelectedFile();
            FileButton.setText(file.getAbsolutePath());
        }
    }
}