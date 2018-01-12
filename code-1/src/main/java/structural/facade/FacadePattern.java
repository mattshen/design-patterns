package structural.facade;

/**
 * Simplify a complex system by provide simple interface
 */

/* Complex parts */
class CPU {
    public void freeze()
    {
        System.out.println("freeze");
    }

    public void jump(long position)
    {
        System.out.println("jump");
    }

    public void execute()
    {
        System.out.println("execute");
    }
}

class HardDrive {
    public byte[] read(long lba, int size)
    {
        System.out.println("read");
        return new byte[]{};
    }
}

class Memory {
    public void load(long position, byte[] data)
    {
        System.out.println("load");
    }
}

/* Facade */

class ComputerFacade {

    private static long BOOT_ADDRESS = 0L;
    private static long BOOT_SECTOR = 0L;
    private static int SECTOR_SIZE= 100;

    private CPU processor;
    private Memory ram;
    private HardDrive hd;

    public ComputerFacade()
    {
        this.processor = new CPU();
        this.ram = new Memory();
        this.hd = new HardDrive();
    }

    public void start()
    {
        processor.freeze();
        ram.load(BOOT_ADDRESS, hd.read(BOOT_SECTOR, SECTOR_SIZE));
        processor.jump(BOOT_ADDRESS);
        processor.execute();
    }
}

public class FacadePattern {
    public static void main(String[] args)
    {
        ComputerFacade computer = new ComputerFacade();
        computer.start();
    }
}
