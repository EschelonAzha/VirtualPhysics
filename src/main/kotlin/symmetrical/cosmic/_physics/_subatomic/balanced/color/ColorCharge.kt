package symmetrical.cosmic._physics._subatomic.balanced.color

import symmetrical.cosmic._physics._subatomic.matter.colors.Green
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class ColorCharge(
    private val fermion: IFermion = Fermion(ColorCharge::class),
) :
    IFermion by fermion,
    IColorCharge
{
    constructor() : this (
        Fermion(ColorCharge::class),
    )

    lateinit var atom     : Atom

    override fun getClassId() : String {
        return fermion.getClassId()
    }

    override fun setAtom(atom: Atom) : Atom {
        this.atom = atom
        return atom
    }
    override fun blue() : String {
        return atom.nucleons.getValueProton().blue() as String
    }
    override fun green() : String {
        return atom.nucleons.getValueProton().green() as String
    }
    override fun red() : Any {
        return ""
    }
    override fun currentColor() : Any? {
        return atom.nucleons.getValueProton().currentColor()
    }
    override fun setGreen(green: Green) : Atom {
        atom.nucleons.getValueProton().setGreen(green)
        return atom
    }
}