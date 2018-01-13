package behavioral;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

abstract class PurchasePower
{
    protected static final double BASE = 500;
    protected PurchasePower successor;

    abstract protected double getAllowable();

    abstract protected String getRole();

    public void setSuccessor(PurchasePower successor)
    {
        this.successor = successor;
    }

    public void processRequest(PurchaseRequest request)
    {
        if (request.getAmount() < this.getAllowable()) {
            System.out.println(this.getRole() + " will approve $" + request.getAmount());
        } else if (successor != null) {
            successor.processRequest(request);
        }
    }
}

class ManagerPPower extends PurchasePower
{
    protected double getAllowable()
    {
        return BASE * 10;
    }

    protected String getRole()
    {
        return "Manager";
    }
}

class DirectorPPower extends PurchasePower
{
    protected double getAllowable()
    {
        return BASE * 20;
    }

    protected String getRole()
    {
        return "Director";
    }
}

class VicePresidentPPower extends PurchasePower
{
    protected double getAllowable()
    {
        return BASE * 40;
    }

    protected String getRole()
    {
        return "Vice President";
    }
}

class PresidentPPower extends PurchasePower
{
    protected double getAllowable()
    {
        return BASE * 60;
    }

    protected String getRole()
    {
        return "President";
    }
}

class PurchaseRequest
{
    private double amount;
    private String purpose;

    public PurchaseRequest(double amount, String purpose)
    {
        this.amount = amount;
        this.purpose = purpose;
    }

    public double getAmount()
    {
        return this.amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public String getPurpose()
    {
        return this.purpose;
    }

    public void setPurpose(String purpose)
    {
        this.purpose = purpose;
    }

}

public class CoRPattern
{
    public static void main(String[] args) throws IOException
    {
        ManagerPPower manager = new ManagerPPower();
        DirectorPPower director = new DirectorPPower();
        VicePresidentPPower vp = new VicePresidentPPower();
        PresidentPPower president = new PresidentPPower();
        manager.setSuccessor(director);
        director.setSuccessor(vp);
        vp.setSuccessor(president);

        System.out.println("Enter the amount to check who should approve your expenditure.");
        System.out.print(">");
        double d = Double.parseDouble(
                new BufferedReader(
                        new InputStreamReader(System.in)).readLine());
        manager.processRequest(new PurchaseRequest(d, "General"));
    }
}
