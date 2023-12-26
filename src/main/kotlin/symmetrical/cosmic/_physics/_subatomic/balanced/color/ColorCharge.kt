package symmetrical.cosmic._physics._subatomic.balanced.color

import symmetrical.cosmic._physics._subatomic.matter.colors.Green
import symmetrical.cosmic._physics.atomic.atoms.Atom

class ColorCharge : IColorCharge {
    lateinit var atom     : Atom
    constructor()

    override fun blue() : String {
        return atom.nucleons.getValueProton().blue() as String
    }
    override fun currentColor() : Any? {
        return atom.nucleons.getValueProton().currentColor()
    }
    override fun green() : String {
        return atom.nucleons.getValueProton().green() as String
    }
    override fun red() : Any {
        return ""
    }

    override fun setAtom(atom: Atom) : Atom {
        this.atom = atom
        return atom
    }
    override fun setGreen(green: Green) : Atom {
        atom.nucleons.getValueProton().setGreen(green)
        return atom
    }
}