package symmetrical.cosmic._physics._subatomic.balanced.color

import symmetrical.cosmic._physics._subatomic.matter.colors.Green
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic.dictionary.protons.ValueProton
/*
https://en.wikipedia.org/wiki/Color_charge
*/
class ColorCharge : IColorCharge {
    lateinit var atom     : Atom
    constructor()

    override fun blue() : String {
        return atom._nucleons.getProton(ValueProton::class).blue() as String
    }
    override fun currentColor() : Any? {
        return atom._nucleons.getProton(ValueProton::class).currentColor()
    }
    override fun green() : String {
        return atom._nucleons.getProton(ValueProton::class).green() as String
    }
    override fun red() : Any {
        return ""
    }

    override fun setAtom(atom: Atom) : Atom {
        this.atom = atom
        return atom
    }
    override fun setGreen(green: Green) : Atom {
        atom._nucleons.getProton(ValueProton::class).setGreen(green)
        return atom
    }
}