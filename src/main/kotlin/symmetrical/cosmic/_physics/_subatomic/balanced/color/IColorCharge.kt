package symmetrical.cosmic._physics._subatomic.balanced.color

import symmetrical.cosmic._physics._subatomic.matter.colors.Green
import symmetrical.cosmic._physics.atomic.atoms.Atom

interface IColorCharge {
    fun blue        ()                  : String
    fun green       ()                  : String
    fun red         ()                  : Any
    fun currentColor()                  : Any?
    fun getClassId  ()                  : String
    fun setAtom     (atom:Atom)         : Atom
    fun setGreen    (green: Green)      : Atom
}