import javax.swing.*;
import java.util.Objects;

public class Blanket {
    private final String[] AvailableSizes = {"Twin", "Double", "Queen", "King"};
    private final String[] AvailableMaterial = {"Cotton", "Wool", "Cashmere"};
    private final String[] AvailableDiscount = {"1234567", "BetterDiscount", "SecretCode"};
    private String Size;
    private String Color;
    private String Material;
    private double Price;
    private boolean InStock = true;
    private static int AmountLeft = 10;
    private double Discount;
    private String Brand = "Unbranded";

    public Blanket() {
        Size = "Twin";
        Color = "White";
        Material = "Cotton";
        Price = 30.0;
    }

    public Blanket(String Size, String Color, String Material) {
        this();
        this.setSize(Size);
        this.setColor(Color);
        this.setMaterial(Material);
    }

    public Blanket(String Size, String Material) {
        this();
        this.setSize(Size);
        this.setMaterial(Material);
    }

    public Blanket(double Price) {
        this();
        this.Price = Price;
    }

    public Blanket(double Price, double Discount, String Brand) {
        this();
        this.Price = Price;
        this.Discount = Discount;
        this.Brand = Brand;
        this.InStock = AmountLeft > 0;
    }

    public String getSize() {
        return Size;
    }

    public String getColor() {
        return Color;
    }

    public double getPrice() {
        return Price;
    }

    public String getMaterial() {
        return Material;
    }

    public boolean getInStock() {
        return InStock;
    }

    public int getAmountLeft() {
        return AmountLeft;
    }

    public double getDiscount() {
        return this.Discount;
    }

    public String getBrand() {
        return Brand;
    }

    public void setSize(String Size) {
        for (String S : AvailableSizes) {
            if (Objects.equals(S, Size)) {
                this.Size = Size;
                if (Objects.equals(Size, "Double")) {
                    this.Price += 10;
                } else if (Objects.equals(Size, "Queen")) {
                    this.Price += 25;
                } else if (Objects.equals(Size, "King")) {
                    this.Price += 40;
                }
                return;
            }
        }

        this.Size = "Twin";
    }

    public void setMaterial(String Material) {
        for (String S : AvailableMaterial) {
            if (Objects.equals(S, Material)) {
                this.Material = Material;
                if (Objects.equals(Material, "Wool")) {
                    this.Price += 20;
                } else if (Objects.equals(Material, "Cashmere")) {
                    this.Price += 45;
                }

                return;
            }
        }

        this.Material = "Cotton";
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public void setPrice(double Price) {
        this.Price = Price;
        this.setMaterial(this.Material);
        this.setSize(this.Size);
    }

    public void setInStock(boolean InStock) {
        this.InStock = InStock;

        if (!InStock) {
            this.AmountLeft = 0;
            return;
        }

        if (this.AmountLeft == 0) {
            this.AmountLeft++;
        }
    }

    public void setAmountLeft(int AmountLeft) {
        if (AmountLeft <= 0) {
            this.InStock = false;
        }

        this.AmountLeft = AmountLeft;
    }

    public void setDiscount(double Discount) {
        this.Discount = Discount;
    }

    public void setBrand(String Brand) {
        this.Brand = Brand;
    }

    public String toString() {
        return "Blanket Info\n=============\nSize : " + getSize() + "\nColor : " + getColor() + "\nMaterial : " + getMaterial() + (getDiscount() > 0 ? "\nThe Original Price is " + getPrice() + "\nWith Discount" +
                " its : " + (getPrice() - (getPrice() * (getDiscount() / 100.0))) : "\nPrice : " + getPrice()) + (InStock ? "\nThe Blanket is in Stock\nAmount left : " + getAmountLeft() : "\nThe Blanket is not in Stock") +
                "\nBrand : " + getBrand();
    }

    public final void AddOneBlanket() {
        this.AmountLeft++;
    }

    public final void RemoveOneBlanket() {
        if (this.AmountLeft == 0) {
            JOptionPane.showMessageDialog(null,"No more blankets left come back another day");
        } else {
            this.AmountLeft--;
        }
    }

    protected double getAppliedDiscount() {
        return getPrice() - (getPrice() * (getDiscount() / 100));
    }

    public double AccessGetAppliedDiscount() {
        return this.getAppliedDiscount();
    }

    protected void ShowAvailableSizes() {
        System.out.print("The available sizes are : ");
        for (String S : this.AvailableSizes) {
            System.out.print(S + ", ");
        }
        System.out.println("\b\b");
    }

    public void AccessShowAvailableSizes() {
        this.ShowAvailableSizes();
    }

    protected void ShowAvailableMaterials() {
        String word = "" ;
        word += "The available Materials are : ";
        for (String S : this.AvailableMaterial) {

            word += S + ", " ;

        }

        word += "\b\b";

        JOptionPane.showMessageDialog(null,"<html>" + word.replace("\b", "<b>") + "</html>");
    }

    protected void CheckDiscountCode(String Code) {
        for (String S : AvailableDiscount) {
            if (Objects.equals(S, Code)) {
                this.setDiscount(10.0);
                JOptionPane.showMessageDialog(null,"Discount Applied !");
                return;
            }
        }

        JOptionPane.showMessageDialog(null,"Invalid Discount");
    }
}