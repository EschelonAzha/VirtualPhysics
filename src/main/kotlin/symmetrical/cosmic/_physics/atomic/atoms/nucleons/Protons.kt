package symmetrical.cosmic._physics.atomic.atoms.nucleons

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.matter.bosons.ZBoson
import symmetrical.cosmic._physics._subatomic.spacial.ParticleBeam
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Baryon
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Proton
import symmetrical.cosmic._physics._subatomic.matter.leptons.Electron
import symmetrical.cosmic._physics._subatomic.matter.quarks.Up
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter

class Protons(
    private val matter: IMatter = Matter(Protons::class, Protons::class, true),
) : ParticleBeam(),
    IMatter by matter,
    IProtons
{
    constructor() : this(
        Matter(Protons::class, Protons::class, true),
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
        matter.check(photon);

        clear()
        val remainder = super.absorb(photon.propagate())
        shrink()
        for (i in 0 until size()) {
            (get(i) as Proton).setProtons(this)
        }
        return remainder
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return matter.getClassId()+super.emit().radiate()
    }

    override fun getClassId() : String {
        return matter.getClassId()
    }

    override fun addProton(proton: Proton) : Proton {
        add(proton)
        return proton
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
    override fun setNucleons(nucleons:Nucleons) : Nucleons {
        this.__nucleons = nucleons
        return nucleons
    }
    override fun setAtomicNumber(number:Int) : Nucleons {
        var i=size()
        while (i<number) {
            add(Baryon().Proton() as Baryon)
            i++
        }
        return __nucleons as Nucleons
    }

    fun getElectron(proton: Proton) : Electron {
        val electronNum = beam.find(proton)
        return getAtom().getElectron(electronNum)
    }
    fun getCurrentValue() : Any? {
        return getCurrentValueProton().getValue()
    }
    fun setCurrentValue(zBoson: ZBoson) : ZBoson {
        getCurrentValueProton().interact(zBoson)
        return zBoson
    }
    fun getCurrentValueProton() : Proton {
        return getProton(ProtonType.CURRENT_VALUE)
    }
    private fun getProton(type: ProtonType) : Proton {
        return get(type.value) as Proton
    }
    fun capacitanceChange(proton: Proton, valueQuark: Up, zBoson: ZBoson) : ZBoson {
        return getAtom().capacitanceChange(proton, valueQuark, zBoson)
    }
    fun valueChange(proton: Proton, valueQuark: Up, zBoson: ZBoson) : ZBoson {
        return getAtom().valueChange(proton, valueQuark, zBoson)
    }
}