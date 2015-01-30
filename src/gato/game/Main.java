/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gato.game;

/**
 *
 * @author Gloriana
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Game model = new Game();
        Interface view = new Interface();
        Controller  controller = new Controller(view , model);
        controller.openView();
        view.setVisible(true);
    }
}
