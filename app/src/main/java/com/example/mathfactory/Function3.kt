package com.example.mathfactory
import android.content.Intent
import android.graphics.Color
import android.graphics.Color.rgb
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_function3.*
import java.io.File
import kotlin.math.*
class Function3 : AppCompatActivity()
{
    var passo:Double=0.1
    var inf:Double=0.0
    var sup:Double=0.1
    var identifier:Int=0
    var A:Double=0.0
    var f:Double=0.0
    var p:Double=0.0
    var x:Double=0.0
    var titolo=""
    var interpolat=false
    var controllo=true
    var identifier2:Int=0
    var A2:Double=0.0
    var f2:Double=0.0
    var p2:Double=0.0
    var x2:Double=0.0
    var titolo2=""
    var interpolat2=false
    var controllo2=true
    var turno=false
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_function3)
        button8.setOnClickListener {if(!turno)identifier=18 else identifier2=18;set_color(identifier);if(!interpolat){interpolat=true;interpolat2=true;button8.text="Interpolat\nOn"}else{interpolat=false;interpolat2=false;button8.text="Interpolat\nOff"}}
        button9.setOnClickListener {if(!turno){identifier=16;set_color(identifier)}else{identifier2=16;set_color(identifier2)}}
        button10.setOnClickListener {if(!turno){identifier=14;set_color(identifier)}else{identifier2=14;set_color(identifier2)}}
        button11.setOnClickListener {if(!turno){identifier=17;set_color(identifier)}else{identifier2=17;set_color(identifier2)}}
        button30.setOnClickListener {if(!turno){identifier=15;set_color(identifier)}else{identifier2=15;set_color(identifier2)}}
        button31.setOnClickListener {if(!turno){identifier=13;set_color(identifier)}else{identifier2=13;set_color(identifier2)}}
        button32.setOnClickListener {if(!turno){identifier=5;set_color(identifier)}else{identifier2=5;set_color(identifier2)}}
        button33.setOnClickListener {if(!turno){identifier=6;set_color(identifier)}else{identifier2=6;set_color(identifier2)}}
        button37.setOnClickListener {if(!turno){identifier=7;set_color(identifier)}else{identifier2=7;set_color(identifier2)}}
        button38.setOnClickListener {if(!turno){identifier=8;set_color(identifier)}else{identifier2=8;set_color(identifier2)}}
        button39.setOnClickListener {if(!turno){identifier=19;set_color(identifier)}else{identifier2=19;set_color(identifier2)}}
        button40.setOnClickListener {if(!turno){identifier=20;set_color(identifier)}else{identifier2=20;set_color(identifier2)}}
        button45.setOnClickListener {if(!turno){identifier=1;set_color(identifier)}else{identifier2=1;set_color(identifier2)}}
        button46.setOnClickListener {if(!turno){identifier=2;set_color(identifier)}else{identifier2=2;set_color(identifier2)}}
        button47.setOnClickListener {if(!turno){identifier=3;set_color(identifier)}else{identifier2=3;set_color(identifier2)}}
        button48.setOnClickListener {if(!turno){identifier=4;set_color(identifier)}else{identifier2=4;set_color(identifier2)}}
        button20.setOnClickListener {if((identifier!=18)&&(!turno)){set_color(21);if(input_output())textView30.setTextColor(Color.RED)else textView30.setTextColor(Color.BLUE);if(identifier!=0)turno=true}}
        button22.setOnClickListener {if((identifier2!=18)&&(turno)){set_color(22);if(input_output_bis())textView23.setTextColor(Color.RED)else textView23.setTextColor(Color.BLUE);if(identifier2!=0)turno=false} }
        button17.setOnClickListener {val next= Intent(this,Grafici::class.java);next.putExtra("passo", passo);next.putExtra("inf", inf);next.putExtra("sup", sup);next.putExtra("identifier", identifier);next.putExtra("A", A);next.putExtra("f", f);next.putExtra("p", p);next.putExtra("x", x);next.putExtra("titolo",titolo);next.putExtra("interpolat",interpolat);next.putExtra("controllo",controllo);next.putExtra("identifier2", identifier2);next.putExtra("A2", A2);next.putExtra("f2", f2);next.putExtra("p2", p2);next.putExtra("x2", x2);next.putExtra("titolo2",titolo2);next.putExtra("interpolat2",interpolat2);next.putExtra("controllo2",controllo2);reset();startActivity(next)}
    }
    override fun onCreateOptionsMenu(menu: Menu):Boolean
    {
        menuInflater.inflate(R.menu.menu_application2, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        val id=item.getItemId()
        if(id==R.id.action_one)
        {
            Toast.makeText(this,"MathFact version 1.0", Toast.LENGTH_LONG).show()
            return true
        }
        if(id==R.id.action_two)
        {
            Toast.makeText(this,"Enjoy with Math!", Toast.LENGTH_LONG).show()
            return true
        }
        if(id==R.id.action_three)
        {
            Toast.makeText(this,"Created by: Raffaele Maddaloni ®", Toast.LENGTH_LONG).show()
            return true
        }
        if(id==R.id.action_home)
        {
            val next= Intent(this,MainActivity::class.java)
            startActivity(next)
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    private fun input_output():Boolean
    {
        if(identifier==0)
        {
            textView30.text = "No function selected!"
            return true
        }
        else
        {
            if ((editText4.text.toString()!="")&&(editText4.text.toString()!=".")&&(editText4.text.toString()!="-"))
                passo=editText4.text.toString().toDouble()
            if ((editText6.text.toString()!="")&&(editText6.text.toString()!=".")&&(editText6.text.toString()!="-"))
                inf=editText6.text.toString().toDouble()
            if ((editText5.text.toString()!="")&&(editText5.text.toString()!=".")&&(editText5.text.toString()!="-"))
                sup=editText5.text.toString().toDouble()
            if ((editText7.text.toString()!="")&&(editText7.text.toString()!=".")&&(editText7.text.toString()!="-"))
                A=editText7.text.toString().toDouble()
            if ((editText10.text.toString()!="")&&(editText10.text.toString()!=".")&&(editText10.text.toString()!="-"))
                f=editText10.text.toString().toDouble()
            if ((editText9.text.toString()!="")&&(editText9.text.toString()!=".")&&(editText9.text.toString()!="-"))
            {
                if ((identifier != 1) && (identifier != 2))
                    p = editText9.text.toString().toDouble()
                else
                    p = editText9.text.toString().toDouble() * PI / 180
            }
            if ((editText8.text.toString()!="")&&(editText8.text.toString()!=".")&&(editText8.text.toString()!="-"))
                x=editText8.text.toString().toDouble()
            integrita()
            when(identifier)
            {
                1->{textView30.text="y(x)="+A.toString()+"*sen(2π*("+f.toString()+")*x+("+p+"))+("+x.toString()+")";titolo="Model Function: y(x)=Asen(2πfx+φ)+k"}
                2->{textView30.text="y(x)="+A.toString()+"*cos(2π*("+f.toString()+")*x+("+p+"))+("+x.toString()+")";titolo="Model Function: y(x)=Acos(2πfx+φ)+k"}
                3->{textView30.text="y(x)="+A.toString()+"*arcsen(x+("+p+"))+("+x.toString()+")";titolo="Model Function: y(x)=Aarcsen(x+h)+k"}
                4->{textView30.text="y(x)="+A.toString()+"*arccos(2π*(x+("+p+"))+("+x.toString()+")";titolo="Model Function: y(x)=Aarccos(x+h)+k"}
                5->{textView30.text="y(x)="+A.toString()+"*exp(x+("+p+"))+("+x.toString()+")";titolo="Model Function: y(x)=Aexp(x+h)+k"}
                6->{textView30.text="y(x)="+A.toString()+"*ln(x+("+p+"))+("+x.toString()+")";titolo="Model Function: y(x)=Aln(x+h)+k"}
                7->{textView30.text="y(x)="+A.toString()+"*10^(x+("+p+"))+("+x.toString()+")";titolo="Model Function: y(x)=A*10^(x+h)+k"}
                8->{textView30.text="y(x)="+A.toString()+"*log10(x+("+p+"))+("+x.toString()+")";titolo="Model Function: y(x)=Alog10(x+h)+k"}
                13->{textView30.text="y(x)="+A.toString()+"/(x+("+p+"))+("+x.toString()+")";titolo="Model Function: y(x)=A/(x+h)+k"}
                14->{textView30.text="y(x)="+A.toString()+"(x+("+p+"))^2+("+x.toString()+")";titolo="Model Function: y(x)=A(x+h)^2+k"}
                15->{textView30.text="y(x)="+A.toString()+"*√(x+("+p+"))+("+x.toString()+")";titolo="Model Function: y(x)=A√(x+h)+k"}
                16->{textView30.text="y(x)="+A.toString()+"(x+("+p+"))+("+x.toString()+")";titolo="Model Function: y(x)=A(x+h)+k"}
                17->{textView30.text="y(x)="+A.toString()+"(x+("+p+"))^3+("+x.toString()+")";titolo="Model Function: y(x)=A(x+h)^3+k"}
                19->{textView30.text="y(x)="+A.toString()+"2^(x+("+p+"))+("+x.toString()+")";titolo="Model Function: y(x)=A*2^(x+h)+k"}
                20->{textView30.text="y(x)="+A.toString()+"log2(x+("+p+"))+("+x.toString()+")";titolo="Model Function: y(x)=Alog2(x+h)+k"}
            }
            return false
        }
    }
    private fun set_color(id:Int)
    {
        val not_selected=rgb(81,153,167)
        val selected=rgb(255,215,0)
        val selected2=rgb(40,114,51)
        val selected3=(rgb(155,17,30))
        button9.setTextColor(not_selected)
        button10.setTextColor(not_selected)
        button11.setTextColor(not_selected)
        button30.setTextColor(not_selected)
        button31.setTextColor(not_selected)
        button32.setTextColor(not_selected)
        button33.setTextColor(not_selected)
        button37.setTextColor(not_selected)
        button38.setTextColor(not_selected)
        button39.setTextColor(not_selected)
        button40.setTextColor(not_selected)
        button45.setTextColor(not_selected)
        button46.setTextColor(not_selected)
        button47.setTextColor(not_selected)
        button48.setTextColor(not_selected)
        when(id)
        {
            18->if(!interpolat)button8.setTextColor(selected2)else button8.setTextColor(selected3)
            16->button9.setTextColor(selected)
            14->button10.setTextColor(selected)
            17->button11.setTextColor(selected)
            15->button30.setTextColor(selected)
            13->button31.setTextColor(selected)
            5->button32.setTextColor(selected)
            6->button33.setTextColor(selected)
            7->button37.setTextColor(selected)
            8->button38.setTextColor(selected)
            19->button39.setTextColor(selected)
            20->button40.setTextColor(selected)
            1->button45.setTextColor(selected)
            2->button46.setTextColor(selected)
            3->button47.setTextColor(selected)
            4->button48.setTextColor(selected)
            21->if(identifier!=0)button20.setTextColor(selected2)
            22->if(identifier!=0)button22.setTextColor(selected2)
        }
    }
    private fun reset()
    {
        passo=0.1
        inf=0.0
        sup=0.1
        identifier=0
        A=0.0
        f=0.0
        p=0.0
        x=0.0
        identifier2=0
        A2=0.0
        f2=0.0
        p2=0.0
        x2=0.0
        titolo=""
        titolo2=""
        textView30.text=""
        button20.setTextColor(rgb(155,17,30))
        button22.setTextColor(rgb(155,17,30))
        button8.setTextColor(rgb(155,17,30))
        interpolat=false
        controllo=true
        interpolat2=false
        controllo2=true
        button8.text="Interpolat\nOff"
        editText4.setText("")
        editText5.setText("")
        editText6.setText("")
        editText7.setText("")
        editText8.setText("")
        editText9.setText("")
        editText10.setText("")
        turno=false
    }
    private fun integrita()
    {
        if(passo<0.001)
            passo=0.001
        if(inf>=sup)
        {
            passo=0.1
            inf=0.toDouble()
            sup=0.1
            controllo=false
        }
        if(((identifier==3)||(identifier==4))&&((inf<-1)||(sup>1)))
        {
            if(inf<-1)
                inf=-1.toDouble()
            if(sup>1)
                sup=1.toDouble()
        }
        if(((identifier==3)||(identifier==4))&&((sup<-1)||(inf>1)))
        {
            identifier=3
            passo=0.1
            inf=0.0
            sup=0.1
            controllo=false
        }
        if((identifier==15)&&((inf<0)||(sup<0)))
        {
            passo=0.1
            inf=0.0
            sup=0.1
            controllo=false
        }
        if(((identifier==6)||(identifier==8)||(identifier==20))&&((inf<=0)||(sup<=0)))
        {
            identifier=15
            passo=0.1
            inf=0.0
            sup=0.1
            controllo=false
        }
        if(((identifier==5)||(identifier==19))&&(sup>20))
        {
            sup=20.toDouble()
        }
        if((identifier==7)&&(sup>10))
        {
            sup=10.toDouble()
        }
    }
    private fun input_output_bis():Boolean
    {
        if(identifier2==0)
        {
            textView23.text = "No function selected!"
            return true
        }
        else
        {
            if ((editText4.text.toString()!="")&&(editText4.text.toString()!=".")&&(editText4.text.toString()!="-"))
                passo=editText4.text.toString().toDouble()
            if ((editText6.text.toString()!="")&&(editText6.text.toString()!=".")&&(editText6.text.toString()!="-"))
                inf=editText6.text.toString().toDouble()
            if ((editText5.text.toString()!="")&&(editText5.text.toString()!=".")&&(editText5.text.toString()!="-"))
                sup=editText5.text.toString().toDouble()
            if ((editText7.text.toString()!="")&&(editText7.text.toString()!=".")&&(editText7.text.toString()!="-"))
                A2=editText7.text.toString().toDouble()
            if ((editText10.text.toString()!="")&&(editText10.text.toString()!=".")&&(editText10.text.toString()!="-"))
                f2=editText10.text.toString().toDouble()
            if ((editText9.text.toString()!="")&&(editText9.text.toString()!=".")&&(editText9.text.toString()!="-"))
            {
                if ((identifier2 != 1) && (identifier2 != 2))
                    p2 = editText9.text.toString().toDouble()
                else
                    p2 = editText9.text.toString().toDouble() * PI / 180
            }
            if ((editText8.text.toString()!="")&&(editText8.text.toString()!=".")&&(editText8.text.toString()!="-"))
                x2=editText8.text.toString().toDouble()
            integrita2()
            when(identifier2)
            {
                1->{textView23.text="y(x)="+A.toString()+"*sen(2π*("+f.toString()+")*x+("+p+"))+("+x.toString()+")";titolo2="Model Function: y(x)=Asen(2πfx+φ)+k"}
                2->{textView23.text="y(x)="+A.toString()+"*cos(2π*("+f.toString()+")*x+("+p+"))+("+x.toString()+")";titolo2="Model Function: y(x)=Acos(2πfx+φ)+k"}
                3->{textView23.text="y(x)="+A.toString()+"*arcsen(x+("+p+"))+("+x.toString()+")";titolo2="Model Function: y(x)=Aarcsen(x+h)+k"}
                4->{textView23.text="y(x)="+A.toString()+"*arccos(2π*(x+("+p+"))+("+x.toString()+")";titolo2="Model Function: y(x)=Aarccos(x+h)+k"}
                5->{textView23.text="y(x)="+A.toString()+"*exp(x+("+p+"))+("+x.toString()+")";titolo2="Model Function: y(x)=Aexp(x+h)+k"}
                6->{textView23.text="y(x)="+A.toString()+"*ln(x+("+p+"))+("+x.toString()+")";titolo2="Model Function: y(x)=Aln(x+h)+k"}
                7->{textView23.text="y(x)="+A.toString()+"*10^(x+("+p+"))+("+x.toString()+")";titolo2="Model Function: y(x)=A*10^(x+h)+k"}
                8->{textView23.text="y(x)="+A.toString()+"*log10(x+("+p+"))+("+x.toString()+")";titolo="Model Function: y(x)=Alog10(x+h)+k"}
                13->{textView23.text="y(x)="+A.toString()+"/(x+("+p+"))+("+x.toString()+")";titolo2="Model Function: y(x)=A/(x+h)+k"}
                14->{textView23.text="y(x)="+A.toString()+"(x+("+p+"))^2+("+x.toString()+")";titolo2="Model Function: y(x)=A(x+h)^2+k"}
                15->{textView23.text="y(x)="+A.toString()+"*√(x+("+p+"))+("+x.toString()+")";titolo2="Model Function: y(x)=A√(x+h)+k"}
                16->{textView23.text="y(x)="+A.toString()+"(x+("+p+"))+("+x.toString()+")";titolo2="Model Function: y(x)=A(x+h)+k"}
                17->{textView23.text="y(x)="+A.toString()+"(x+("+p+"))^3+("+x.toString()+")";titolo2="Model Function: y(x)=A(x+h)^3+k"}
                19->{textView23.text="y(x)="+A.toString()+"2^(x+("+p+"))+("+x.toString()+")";titolo2="Model Function: y(x)=A*2^(x+h)+k"}
                20->{textView23.text="y(x)="+A.toString()+"log2(x+("+p+"))+("+x.toString()+")";titolo2="Model Function: y(x)=Alog2(x+h)+k"}
            }
            return false
        }
    }
    private fun integrita2()
    {
        if(passo<0.001)
            passo=0.001
        if(inf>=sup)
        {
            passo=0.1
            inf=0.toDouble()
            sup=0.1
            controllo2=false
        }
        if(((identifier2==3)||(identifier2==4))&&((inf<-1)||(sup>1)))
        {
            if(inf<-1)
                inf=-1.toDouble()
            if(sup>1)
                sup=1.toDouble()
        }
        if(((identifier2==3)||(identifier2==4))&&((sup<-1)||(inf>1)))
        {
            identifier2=3
            passo=0.1
            inf=0.0
            sup=0.1
            controllo2=false
        }
        if((identifier2==15)&&((inf<0)||(sup<0)))
        {
            passo=0.1
            inf=0.0
            sup=0.1
            controllo2=false
        }
        if(((identifier2==6)||(identifier2==8)||(identifier2==20))&&((inf<=0)||(sup<=0)))
        {
            identifier2=15
            passo=0.1
            inf=0.0
            sup=0.1
            controllo2=false
        }
        if(((identifier2==5)||(identifier2==19))&&(sup>20))
        {
            sup=20.toDouble()
        }
        if((identifier2==7)&&(sup>10))
        {
            sup=10.toDouble()
        }
    }
}

