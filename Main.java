
import javax.swing.SwingUtilities;


public class Main {
    public static final int width = 1024;
    public static final int height = 800;

    public static void main(String[] args) {
        // desktop

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                Desktop desktop = new Desktop();

                // example create window inside the desktop
                desktop.CreateWindow("Second", 640, 480);

                // example create window inside the desktop
                desktop.CreateWindow("First", new Vector2(400, 200), 100, 200);

                //Desktop desktop1 = new Desktop();
                //desktop1.CreateWindow("main window", 640, 480);

                //desktop1.CreateWindow("second window", new Vector2(400, 200), 100, 200);

            }
        });


    }
}
