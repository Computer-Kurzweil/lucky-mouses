package org.woehlke.computer.kurzweil.lucky.mouses;

import org.woehlke.computer.kurzweil.lucky.mouses.config.ComputerKurzweilProperties;
import org.woehlke.computer.kurzweil.lucky.mouses.view.LuckyMousesFrame;

/**
 * Mandelbrot Set drawn by a Turing Machine.
 *
 * (C) 2006 - 2022 Thomas Woehlke.
 * @author Thomas Woehlke
 *
 * @see LuckyMousesFrame
 * @see ComputerKurzweilProperties
 *
 * @see <a href="https://github.com/Computer-Kurzweil/mandelbrot-julia">Github Repository</a>
 * @see <a href="https://java.woehlke.org/mandelbrot-julia/">Maven Project Repository</a>
 */
public class LuckyMousesApplication {

    private LuckyMousesApplication() {
        String conf = "application.yml";
        String jarPath = "target/lucky-mouses.jar";
        ComputerKurzweilProperties config = ComputerKurzweilProperties.propertiesFactory(conf,jarPath);
        LuckyMousesFrame frame = new LuckyMousesFrame(config);
        frame.start();
    }

    /**
     * Starting the Application.
     * @param args CLI Parameter
     */
    public static void main(String[] args) {
        LuckyMousesApplication application = new LuckyMousesApplication();
    }
}
