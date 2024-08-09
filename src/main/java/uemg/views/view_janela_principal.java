package uemg.views;

import uemg.views.views_cadastro.*;
import uemg.views.views_visualizar.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class view_janela_principal {
    private JPanel panelMain;

    private final JMenuItem cadastrarAcervoAcademicoItem;
    private final JMenuItem cadastrarAcervoCartazesItem;
    private final JMenuItem cadastrarAcervoLivrosItem;
    private final JMenuItem cadastrarAcervoMapasItem;
    private final JMenuItem cadastrarAcervoMidiasItem;
    private final JMenuItem cadastrarAcervoPeriodicosItem;
    private final JMenuItem cadastrarAcervoRelatoriosItem;

    private final JMenuItem visualizarAcervoAcademicoItem;
    private final JMenuItem visualizarAcervoCartazesItem;
    private final JMenuItem visualizarAcervoLivrosItem;
    private final JMenuItem visualizarAcervoMapasItem;
    private final JMenuItem visualizarAcervoMidiasItem;
    private final JMenuItem visualizarAcervoPeriodicosItem;
    private final JMenuItem visualizarAcervoRelatoriosItem;

    public view_janela_principal() {
        JFrame frame = new JFrame("Biblioteca Universitária");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configurando a barra de menu
        JMenuBar menuBar = new JMenuBar();
        JMenu loginMenu = new JMenu("Login");
        JMenu cadastroMenu = new JMenu("Cadastro");
        JMenu visualizarMenu = new JMenu("Visualizar");
        JMenuItem logarItem = new JMenuItem("Logar");
        JMenuItem sairItem = new JMenuItem("Sair");

        cadastrarAcervoAcademicoItem = new JMenuItem("Acervo Acadêmico");
        cadastrarAcervoCartazesItem = new JMenuItem("Acervo de Cartazes");
        cadastrarAcervoLivrosItem = new JMenuItem("Acervo de Livros");
        cadastrarAcervoMapasItem = new JMenuItem("Acervo de Mapas");
        cadastrarAcervoMidiasItem = new JMenuItem("Acervo de Mídias");
        cadastrarAcervoPeriodicosItem = new JMenuItem("Acervo de Periódicos");
        cadastrarAcervoRelatoriosItem = new JMenuItem("Acervo de Relatórios");

        visualizarAcervoAcademicoItem = new JMenuItem("Acervo Acadêmico");
        visualizarAcervoCartazesItem = new JMenuItem("Acervo de Cartazes");
        visualizarAcervoLivrosItem = new JMenuItem("Acervo de Livros");
        visualizarAcervoMapasItem = new JMenuItem("Acervo de Mapas");
        visualizarAcervoMidiasItem = new JMenuItem("Acervo de Mídias");
        visualizarAcervoPeriodicosItem = new JMenuItem("Acervo de Periódicos");
        visualizarAcervoRelatoriosItem = new JMenuItem("Acervo de Relatórios");



        cadastroMenu.add(cadastrarAcervoAcademicoItem);
        cadastroMenu.add(cadastrarAcervoCartazesItem);
        cadastroMenu.add(cadastrarAcervoLivrosItem);
        cadastroMenu.add(cadastrarAcervoMapasItem);
        cadastroMenu.add(cadastrarAcervoMidiasItem);
        cadastroMenu.add(cadastrarAcervoPeriodicosItem);
        cadastroMenu.add(cadastrarAcervoRelatoriosItem);

        visualizarMenu.add(visualizarAcervoAcademicoItem);
        visualizarMenu.add(visualizarAcervoCartazesItem);
        visualizarMenu.add(visualizarAcervoLivrosItem);
        visualizarMenu.add(visualizarAcervoMapasItem);
        visualizarMenu.add(visualizarAcervoMidiasItem);
        visualizarMenu.add(visualizarAcervoPeriodicosItem);
        visualizarMenu.add(visualizarAcervoRelatoriosItem);

        loginMenu.add(logarItem);
        loginMenu.add(sairItem);

        disableMenuItems();

        menuBar.add(loginMenu);
        menuBar.add(cadastroMenu);
        menuBar.add(visualizarMenu);

        frame.setJMenuBar(menuBar);

        panelMain = new JPanel();
        panelMain.setLayout(new BorderLayout());

        frame.setContentPane(panelMain);
        frame.pack();
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        //Menu Logar
        logarItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new view_login(view_janela_principal.this);
            }
        });
        sairItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //Menus de Cadastro
        cadastrarAcervoAcademicoItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new view_cadastro_acervoAcademicos();
            }
        });
        cadastrarAcervoCartazesItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new view_cadastro_acervoCartazes();
            }
        });
        cadastrarAcervoLivrosItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new view_cadastro_acervoLivros();
            }
        });
        cadastrarAcervoMapasItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new view_cadastro_acervoMapas();
            }
        });
        cadastrarAcervoMidiasItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new view_cadastro_acervoMidias();
            }
        });
        cadastrarAcervoPeriodicosItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new view_cadastro_acervoPeriodicos();
            }
        });
        cadastrarAcervoRelatoriosItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new view_cadastro_acervoRelatorios();
            }
        });

        //Menus de visualização
        visualizarAcervoAcademicoItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new view_visualizar_acervoAcademicos();
            }
        });

        visualizarAcervoCartazesItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new view_visualizar_acervoCartazes();
            }
        });

        visualizarAcervoLivrosItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new view_visualizar_acervoLivros();
            }
        });

        visualizarAcervoMapasItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new view_visualizar_acervoMapas();
            }
        });

        visualizarAcervoMidiasItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new view_visualizar_acervoMidias();
            }
        });

        visualizarAcervoPeriodicosItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new view_visualizar_acervoPeriodicos();
            }
        });

        visualizarAcervoRelatoriosItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new view_visualizar_acervoRelatorios();
            }
        });
    }

    public void enableMenuItems() {
        cadastrarAcervoAcademicoItem.setEnabled(true);
        cadastrarAcervoCartazesItem.setEnabled(true);
        cadastrarAcervoLivrosItem.setEnabled(true);
        cadastrarAcervoMapasItem.setEnabled(true);
        cadastrarAcervoMidiasItem.setEnabled(true);
        cadastrarAcervoPeriodicosItem.setEnabled(true);
        cadastrarAcervoRelatoriosItem.setEnabled(true);

        visualizarAcervoAcademicoItem.setEnabled(true);
        visualizarAcervoCartazesItem.setEnabled(true);
        visualizarAcervoLivrosItem.setEnabled(true);
        visualizarAcervoMapasItem.setEnabled(true);
        visualizarAcervoMidiasItem.setEnabled(true);
        visualizarAcervoPeriodicosItem.setEnabled(true);
        visualizarAcervoRelatoriosItem.setEnabled(true);
    }

    public void disableMenuItems() {
        cadastrarAcervoAcademicoItem.setEnabled(false);
        cadastrarAcervoCartazesItem.setEnabled(false);
        cadastrarAcervoLivrosItem.setEnabled(false);
        cadastrarAcervoMapasItem.setEnabled(false);
        cadastrarAcervoMidiasItem.setEnabled(false);
        cadastrarAcervoPeriodicosItem.setEnabled(false);
        cadastrarAcervoRelatoriosItem.setEnabled(false);

        visualizarAcervoAcademicoItem.setEnabled(false);
        visualizarAcervoCartazesItem.setEnabled(false);
        visualizarAcervoLivrosItem.setEnabled(false);
        visualizarAcervoMapasItem.setEnabled(false);
        visualizarAcervoMidiasItem.setEnabled(false);
        visualizarAcervoPeriodicosItem.setEnabled(false);
        visualizarAcervoRelatoriosItem.setEnabled(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(view_janela_principal::new);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panelMain = new JPanel();
        panelMain.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panelMain;
    }
}
