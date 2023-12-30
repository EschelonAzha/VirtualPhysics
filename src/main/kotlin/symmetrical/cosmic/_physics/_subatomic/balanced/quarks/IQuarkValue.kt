package symmetrical.cosmic._physics._subatomic.balanced.quarks

import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum.AngularMomentum
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics._subatomic.matter.bosons.ZBoson
import symmetrical.cosmic._physics.atomic.atoms.Atom

interface IQuarkValue {

    fun quarkSpin       ()                                  : Boolean
    fun quarkValue      ()                                  : Any?
    fun getClassId      ()                                  : String
    fun setAtom         (atom: Atom)                        : Atom
    fun setQuarkMomentum(momentum: AngularMomentum)         : Atom
    fun setQuarkSpin    (spin: Spin)                        : Atom
    fun setQuarkValue   (value:Any?)                        : ZBoson
}