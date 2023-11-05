package websites.tests.alloys

import symmetrical.cosmic._physics.atomic.substance.Substance


class _Right : Right {
    var _value:String = "Right"

    override fun addDerived(substance: Substance) : Substance {
        return this;
    }
    override fun getValue() : String {
        return this._value;
    }
    override fun getRightValue() : String {
        return this._value;
    }

    override fun setRightValue(value:String) : Right {
        this._value = value;
        return this
    }
    override fun run() : Unit {
        println("Right running")
    }
}