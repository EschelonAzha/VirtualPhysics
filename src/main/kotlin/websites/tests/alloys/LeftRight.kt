package websites.tests.alloys

import symmetrical.cosmic._physics.atomic.bonds.alloys.Alloy
import symmetrical.cosmic._physics.atomic.substance.Substance


class LeftRight(left: Left, private val right: Right) : Alloy(left, right), Left by left, Right by right {

    override fun addDerived(substance: Substance) : Substance {
        return substance;
    }
    override fun getValue() : String {
        return this.getLeft().getValue()
    }
    fun getLeft() : Left {
        return getSubstance(0) as Left
    }
    fun getRight() : Right {
        return getSubstance(1) as Right
    }

    override fun run() {
        println("In LeftRight");
    }
}