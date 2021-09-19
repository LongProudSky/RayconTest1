public class Card {
    private int CardID;    //卡牌的特定ID
    public String CardTitle;  //卡牌上显示的名称
    public String Statement; // 卡牌描述
    public int Damage;
    public int Health;
    public String type;        //卡牌的类别 Enum{Minion,Spell,Field}(暂定)
    public String CardPic;  //卡牌原画的地址,暂时用路径替代

    public int GetID()
    {
        return this.CardID;
    }

    public void SetID()
    {
        this.CardID = 1000000;
    }

    public Card(String CardTitle,String Statement,String type,String CardPic,int Damage,int Health)
    {
        SetID();
        this.CardTitle = CardTitle;
        this.Statement = Statement;
        this.type = type;
        this.CardPic = CardPic;
        this.Damage = Damage;
        this.Health = Health;
    }

    public void Show()
    {
        System.out.println(this);
    }

    
    public String toString()
    {
        return String.format(
            "识别码：%d\n 名称：%s\n 描述：%s\n 类别：%s\n 立绘地址：%s\n 攻/防：%d/%d\n",
            this.CardID,this.CardTitle,this.Statement,this.type,this.CardPic,this.Damage,this.Health);
    }
}
