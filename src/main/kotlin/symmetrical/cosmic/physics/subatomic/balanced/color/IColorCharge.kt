package symmetrical.cosmic.physics.subatomic.balanced.color

import symmetrical.cosmic.physics.subatomic.matter.colors.Green
import symmetrical.cosmic.physics.atomic.atoms.Atom
/*
https://en.wikipedia.org/wiki/Color_charge
*/
interface IColorCharge {
    fun blue        ()                  : String
    fun currentColor()                  : Any?
    fun green       ()                  : String
    fun red         ()                  : Any

    fun setAtom     (atom: Atom)        : Atom
    fun setGreen    (green: Green)      : Atom
}