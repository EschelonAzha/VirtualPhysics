package symmetrical.electronics.interfaces

import symmetrical.cosmic.physics.atomic.atoms.Atom

interface IConductor {
    fun conductor_(atom: Atom, autoFlow:Boolean=true) : Atom
    fun _conductor(atom: Atom, autoFlow:Boolean=true) : Atom
    fun conductor(atom: Atom, autoFlow:Boolean=true) : Unit

    fun setAtom(atom: Atom) : Atom
}