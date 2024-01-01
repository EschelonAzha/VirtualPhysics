package applications.tests.alloys

import symmetrical.cosmic._physics.atomic.substance.Substance


class _Right : Right {
    var _content:String = "Right"

    override fun addDerived(substance: Substance) : Substance {
        return this;
    }
    override fun getContent() : String {
        return this._content;
    }
    override fun getRightContent() : String {
        return this._content;
    }

    override fun setRightContent(content:String) : Right {
        this._content = content;
        return this
    }
    override fun run() : Unit {
        println("Right running")
    }
}