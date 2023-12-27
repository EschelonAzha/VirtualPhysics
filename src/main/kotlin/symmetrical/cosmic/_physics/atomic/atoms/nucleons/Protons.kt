package symmetrical.cosmic._physics.atomic.atoms.nucleons

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.*
import symmetrical.cosmic._physics._subatomic.matter.bosons.ZBoson
import symmetrical.cosmic._physics._subatomic.spacial.ParticleBeam
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Baryon
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Proton
import symmetrical.cosmic._physics._subatomic.matter.leptons.Electron
import symmetrical.cosmic._physics._subatomic.matter.quarks.Up
import symmetrical.cosmic._physics.atomic.atoms.Atom

class Protons(
    private val matterAntiMatter: IMatterAntiMatter = MatterAntiMatter(Protons::class, Protons::class),
) : ParticleBeam(),
    IMatterAntiMatter by matterAntiMatter,
    IProtons
{
    constructor() : this(
        MatterAntiMatter(Protons::class, Protons::class),
    )    init {
        add(Proton().setProtons(this))
    }
    object Static {
        const val VALUE_PROTON  : Int  = ParticleBeam.Static.LAST + 1
        const val LAST          : Int  = VALUE_PROTON + 1
    }

    enum class ProtonType(val value:Int) {
        CURRENT_VALUE(0),
    }

    private lateinit var __nucleons   : Nucleons

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
    fun capacitanceChange(proton: Proton, valueQuark: Up, zBoson: ZBoson) : ZBoson {
        return getAtom().capacitanceChange(proton, valueQuark, zBoson)
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }

    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }


//
//    override fun findProton(purpose:String) : Int {
//        var i=0;
//        while (i<size()) {
//            val baryon = get(i) as Proton
//            if ((baryon.get(2) as Quark).red() == purpose) {
//                return i
//            }
//            i++
//        }
//        return -1
//    }

    fun getAtom() : Atom {
        return __nucleons.getAtom()
    }
    override fun getAtomicNumber() : Int {
        return size()
    }
    fun getCurrentValue() : Any? {
        return getCurrentValueProton().getValue()
    }
    fun getCurrentValueProton() : Proton {
        return getProton(ProtonType.CURRENT_VALUE)
    }
    fun getElectron(proton: Proton) : Electron {
        val electronNum = beam.find(proton)
        return getAtom().getElectron(electronNum)
    }
    override fun getProton(pos:Int) : Proton {
        return get(pos) as Proton
    }
//    override fun getProton(purpose:String) : Proton {
//        var pos = findProton(purpose)
//
//        if (pos!=-1)
//            return getProton(pos) as Proton
//
//        var proton = Proton()
//        proton.setPurpose(purpose)
//        addProton(proton)
//        return proton
//    }
    override fun getValueProton() : Proton {
        return get(Static.VALUE_PROTON) as Proton
    }

    override fun setAtomicNumber(number:Int) : Nucleons {
        var i=size()
        while (i<number) {
            add(Baryon().Proton() as Baryon)
            i++
        }
        return __nucleons as Nucleons
    }
    fun setCurrentValue(zBoson: ZBoson) : ZBoson {
        getCurrentValueProton().interact(zBoson)
        return zBoson
    }
    override fun setNucleons(nucleons:Nucleons) : Nucleons {
        this.__nucleons = nucleons
        return nucleons
    }

    fun valueChange(proton: Proton, valueQuark: Up, zBoson: ZBoson) : ZBoson {
        return getAtom().valueChange(proton, valueQuark, zBoson)
    }

    private fun getProton(type: ProtonType) : Proton {
        return get(type.value) as Proton
    }

    private fun radiate() : String {
        return matterAntiMatter.getClassId()+
                super.emit().radiate()
    }
}