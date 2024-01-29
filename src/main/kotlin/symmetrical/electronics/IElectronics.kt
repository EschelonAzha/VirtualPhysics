package symmetrical.electronics

import symmetrical.cosmic.physics.atomic.atoms.Atom

interface IElectronics {
    fun capacitor_(atom:Atom) : Atom
    fun _capacitor(atom:Atom) : Atom
    fun capacitor(atom:Atom) : Unit

    fun _conductor(atom: Atom, autoFlow:Boolean) : Atom
    fun conductor(atom: Atom, autoFlow:Boolean=true) : Unit
    fun diode_(atom:Atom, autoFlow:Boolean=true) : Atom
    fun _diode(atom:Atom, autoFlow:Boolean=true) : Atom
    fun diode(atom:Atom, autoFlow:Boolean=true) : Unit
    fun setAtom(atom: Atom) : Atom


}