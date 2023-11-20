package symmetrical.cosmic._physics._subatomic.balanced.color

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.matter.colors.Green
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class ColorCharges(
    private val fermion: IFermion = Fermion(),
) :
    IFermion by fermion,
    IColorCharges
{
    constructor() : this (
        Fermion()
    )

    lateinit var atom     : Atom

    private fun getLocalClassId() : String {
        return Absorber.getClassId(ColorCharges::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
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