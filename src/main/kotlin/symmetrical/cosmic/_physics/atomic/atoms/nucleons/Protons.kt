package symmetrical.cosmic._physics.atomic.atoms.nucleons

import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.wavelength.Wavelength
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.*
import symmetrical.cosmic._physics._subatomic.matter.bosons.ZBoson
import symmetrical.cosmic._physics._subatomic.spacial.ParticleBeam
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Baryon
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Proton
import symmetrical.cosmic._physics._subatomic.matter.leptons.Electron
import symmetrical.cosmic._physics._subatomic.matter.quarks.Down
import symmetrical.cosmic._physics._subatomic.matter.quarks.Up
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic.dictionary.protons.ValueProton
import kotlin.reflect.KClass
/*
https://en.wikipedia.org/wiki/Proton
 */
class Protons(
    private val matterAntiMatter: IMatterAntiMatter = MatterAntiMatter(Protons::class, Protons::class),
) : ParticleBeam(),
    IMatterAntiMatter by matterAntiMatter,
    IProtons
{
    val _valueProton:Proton
    constructor() : this(
        MatterAntiMatter(Protons::class, Protons::class),
    )    init {
        _valueProton = add(ValueProton().setProtons(this)) as ValueProton
    }


    private lateinit var p_nucleons   : Nucleons

    override fun absorb(photon: Photon) : Photon {
        matterAntiMatter.check(photon);

        clear()

        var remainder = photon.propagate()
        remainder = super.absorb(remainder)

        for (i in 0 until size()) {
            (get(i) as Proton).setProtons(this)
        }
        return remainder
    }
    override fun addProton(proton: Proton) : Proton {
        add(proton)
        return proton
    }
    fun capacitanceChange(proton: Proton, valueQuark: Down, zBoson: ZBoson) : ZBoson {
        return getAtom().capacitanceChange(proton, valueQuark, zBoson)
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }

    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }


    fun getAtom() : Atom {
        return p_nucleons.getAtom()
    }
    override fun getAtomicNumber() : Int {
        return size()
    }

    fun getElectron(proton: Proton) : Electron {
        val electronNum = _beam.find(proton)
        return getAtom().getElectron(electronNum)
    }
    override fun getProton(kClass:KClass<*>) : Proton {
        return get(find(kClass)) as Proton
    }

    override fun setAtomicNumber(number:Int) : Nucleons {
        var i=size()
        while (i<number) {
            add(Baryon().Proton() as Baryon)
            i++
        }
        return p_nucleons as Nucleons
    }
    fun setCurrentValue(zBoson: ZBoson) : ZBoson {
        getProton(ValueProton::class).interact(zBoson)
        return zBoson
    }
    override fun setNucleons(nucleons:Nucleons) : Nucleons {
        this.p_nucleons = nucleons
        return nucleons
    }

    fun valueChange(proton: Proton, valueQuark: Down, zBoson: ZBoson) : ZBoson {
        return getAtom().valueChange(proton, valueQuark, zBoson)
    }


    private fun radiate() : String {
        return matterAntiMatter.getClassId()+
                super.emit().radiate()
    }
}