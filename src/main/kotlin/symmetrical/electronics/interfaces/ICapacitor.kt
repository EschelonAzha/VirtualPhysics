package symmetrical.electronics.interfaces

import symmetrical.cosmic.physics.atomic.atoms.Atom

interface ICapacitor {
    fun capacitor_(atom: Atom) : Atom
    fun _capacitor(atom: Atom) : Atom
    fun capacitor(atom: Atom) : Unit

    fun setAtom(atom:Atom) : Atom
}