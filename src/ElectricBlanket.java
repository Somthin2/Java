import javax.swing.*;

public class ElectricBlanket extends Blanket
{
    private int NumberOfHeatSettings;
    private boolean HasAutomaticShutOff;

    public ElectricBlanket()
    {
        super();
        this.HasAutomaticShutOff = false ;
        this.NumberOfHeatSettings = 1;
    }

    public ElectricBlanket(String Size, String Material) {
        super(Size,Material);
        this.HasAutomaticShutOff = false ;
        this.NumberOfHeatSettings = 1;
    }
    public void setNumberOfHeatSettings(int NumberOfHeatSettings)
    {
        if (NumberOfHeatSettings < 1 || NumberOfHeatSettings > 5)
        {
            JOptionPane.showMessageDialog(null, "Min : 1 And Max : 5");
            this.NumberOfHeatSettings = 1;
        }
        else
        {
            this.NumberOfHeatSettings = NumberOfHeatSettings;
        }
    }

    public int getNumberOfHeatSettings() {return this.NumberOfHeatSettings;}

    public void setHasAutomaticShutOff(boolean HasAutomaticShutOff)
    {
        this.HasAutomaticShutOff = HasAutomaticShutOff;

        if (HasAutomaticShutOff)
        {
            this.setPrice(super.getPrice() + 5.75);
        }

    }

    public boolean getHasAutomaticShutOff() {return this.HasAutomaticShutOff;}

    public String toString()
    {
        return super.toString() + "\nNumber of Heat Settings : " + this.NumberOfHeatSettings + (this.HasAutomaticShutOff ? "\nThe Blanket has Automatic ShutOff" : "\nThe Blanket does not have automatic ShutOff") ;
    }


}
