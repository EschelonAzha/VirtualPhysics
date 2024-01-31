package symmetrical.electronics.interfaces

import symmetrical.cosmic.physics.atomic.atoms.Atom

interface IDiode {
    fun diode_(atom: Atom, autoFlow:Boolean=true) : Atom
    fun _diode(atom: Atom, autoFlow:Boolean=true) : Atom
    fun diode(atom: Atom, autoFlow:Boolean=true) : Unit
    fun setAtom(atom:Atom) : Atom
}