package T01WorkingWithAbstraction.lab.P03StudentSystem;

import Workshops.BoatRacingSimulator.input.Reader;

import static Workshops.BoatRacingSimulator.input.ConsolePrinter.printLine;

public class StudentSystem {
    private CommandHandler handler;
    private boolean isWorking;

    public StudentSystem() {
        this.handler = new CommandHandler();
    }

    public void start() {
        this.isWorking = true;
        while (isWorking) {
            String result = handler.handleCommand(Reader.readStringArray("\\s+"));
            isWorking = !"Exit".equals(result);
            if (!isWorking) {
                break;
            }
            if (result != null) {
                printLine(result);
            }
        }
    }
}
