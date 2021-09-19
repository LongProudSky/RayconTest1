using System.Collections;
using System.Collections.Generic;
using UnityEngine;
public class Card  //卡牌基类
    {
        private long CardID;    //卡牌的特定ID
        public string CardTitle;  //卡牌上显示的名称
        public string Statement; // 卡牌描述
        public int type;        //卡牌的类别 Enum{Minion,Spell,Field}(暂定)
        public string CardPic;  //卡牌原画的地址,暂时用路径替代

        public Card(long CardID,string CardTitle,string Statement,int type,string CardPic)
        {
            this.CardID = CardID;
            this.CardTitle = CardTitle;
            this.Statement = Statement;
            this.type = type;
            this.CardPic = CardPic;
        }

        private Show()
        {
            Console.WriteLine(ToString(this));
        }

        public override String ToString()
        {
            StringBuilder sb = new StringBuilder(256)
            sb.Append("CardID:"+CardID+"  ");
            sb.Append("CardTitle:"+CardTitle+"  ");
            sb.Append("Statement:"+Statement+"  ");
            sb.Append("type:"+type+"  ");
            sb.Append("CardPic:"+CardPic+"  ");
            return sb;
        }

    }

