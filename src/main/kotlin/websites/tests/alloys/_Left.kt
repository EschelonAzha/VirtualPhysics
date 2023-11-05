package websites.tests.alloys

import symmetrical.cosmic._physics.atomic.substance.Substance


class _Left : Left {
    var derived = ArrayList<Substance>()


    var _value:String = "Left"

    override fun addDerived(substance:Substance) : Substance {
        //   this.derived.add(substance);
        return this;
    }
    override fun getValue() : String {
        return this._value;
    }
    override fun getLeftValue() : String {
        return this._value
    }
    override fun setLeftValue(value:String) : Left {
        this._value = value;
        return this
    }
    override fun start() : Unit {
        this.run()
    }
    override fun run() : Unit {
        println("left running")
    }
}