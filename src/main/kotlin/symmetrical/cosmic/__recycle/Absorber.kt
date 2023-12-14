package symmetrical.cosmic.__recycle

import asymmetrical.machine.config.Config
import asymmetrical.machine.vm.Classes
import symmetrical.cosmic.__recycle.class_groups.*
import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._physics._subatomic.bosons.*
import kotlin.reflect.KClass

object Absorber {
    val beam: ClassGroup = ClassGroup()
    init {
        beam.addAll(Atoms())
        beam.addAll(Bosons())
        beam.addAll(Charges())
        beam.addAll(Compounds())
        beam.addAll(Cosmic())
        beam.addAll(Encodings())
        beam.addAll(FundamentalProperties())
        beam.addAll(Hadrons())
        beam.addAll(Ions())
        beam.addAll(Leptons())
        beam.addAll(Other())
        beam.addAll(Quarks())
        beam.addAll(Spacial())
        beam.print()
    }

    fun initialize() : Absorber {
        return this
    }
    private fun newInstance(kClass:KClass<*>) : Any? {
        for (i:Int in 0 until beam.size()) {
            val entityId:EntityId = beam.get(i) as EntityId
            if (entityId.has(kClass))
                return entityId.newInstance()
        }
        return null
    }

    fun createInstance(id:String) : Any? {
        for (i in 0 until beam.size()) {
            val entityId = beam.get(i) as EntityId
            if (entityId.id == id) {
                return newInstance(entityId.kClass)
            }
        }
        return null
    }

    fun materialize(photon: Photon) : Pair<IEmitter, String> {
        return materialize(photon.radiate())
    }

    fun materialize(emission:String) : Pair<IEmitter, String> {
        var (classId, remainder) = Strings.remainder(Config.getClassIdLth(), emission)
        val clone = createInstance(classId) as IEmitter
        val remainderPhoton: Photon = clone.absorb(Photon(emission))
        return Pair<IEmitter, String>(clone, remainderPhoton.radiate())
    }
    fun getClassId(kClass: KClass<*>) : String {

        for (i in 0 until beam.size()) {
            val entityId = beam.get(i) as EntityId
            if (entityId.kClass == kClass)
                return entityId.id
        }
        println("")
        println("!!!!!!!!!!!!!!!!!!!")
        println("PhotonDetector::getClassId(kClass:KClass could not find: $kClass")
        println("!!!!!!!!!!!!!!!!!!!")
        println("")
        return ""
    }

    fun createInstancex(id:String) : Any? {
        for (i in 0 until beam.size()) {
            val entityId = beam.get(i) as EntityId
            if (entityId.id == id) {
                return Classes.createInstance(entityId.kClass)
            }
        }
        return null
    }

//    fun newInstanceOld(kClass:KClass<*>) : Any? {
//        val result = when {
//            kClass == Alloy::class                  -> Alloy()
//            kClass == AngularMomentum::class        -> AngularMomentum()
//            kClass == Anion::class                  -> Anion()
//            kClass == AntiColor::class              -> AntiColor()
//            kClass == AntiBlue::class               -> AntiBlue()
//            kClass == AntiBottom::class             -> AntiBottom()
//            kClass == AntiCharm::class              -> AntiCharm()
//            kClass == AntiDown::class               -> AntiDown()
//            kClass == AntiGreen::class              -> AntiGreen()
//            kClass == AntiLepton::class             -> AntiLepton()
//            kClass == AntiMuon::class               -> AntiMuon()
//            kClass == AntiMuonNeutrino::class       -> AntiMuonNeutrino()
//            kClass == AntiNeutrino::class           -> AntiNeutrino()
//            kClass == AntiQuark::class              -> AntiQuark()
//            kClass == AntiRed::class                -> AntiRed()
//            kClass == AntiStrange::class            -> AntiStrange()
//            kClass == AntiTau::class                -> AntiTau()
//            kClass == AntiTauNeutrino::class        -> AntiTauNeutrino()
//            kClass == AntiTop::class                -> AntiTop()
//            kClass == AntiUp::class                 -> AntiUp()
//            kClass == Atom::class                   -> Atom()
//            kClass == Baryon::class                 -> Baryon()
//            kClass == Base52::class                 -> Base52()
//            kClass == Beam::class                   -> Beam(0)
//            kClass == BetaMinus::class              -> BetaMinus()
//            kClass == BetaPlus::class               -> BetaPlus()
//            kClass == BigBang::class                -> BigBang()
//            kClass == Bits04::class                 -> Bits04()
//            kClass == Bits08::class                 -> Bits08()
//            kClass == Bits16::class                 -> Bits16()
//            kClass == Bits24::class                 -> Bits24()
//            kClass == Bits32::class                 -> Bits32()
//            kClass == Bits64::class                 -> Bits64()
//            kClass == Blackhole::class              -> Blackhole()
//            kClass == Blue::class                   -> Blue()
//            kClass == Blue_AntiBlue::class          -> Blue_AntiBlue()
//            kClass == Blue_AntiGreen::class         -> Blue_AntiGreen()
//            kClass == Blue_AntiRed::class           -> Blue_AntiRed()
//            kClass == Bottom::class                 -> Bottom()
//            kClass == Cation::class                 -> Cation()
//            kClass == Characters::class             -> Characters()
//            kClass == Charge::class                 -> Charge()
//            kClass == ChargedWeak::class            -> ChargedWeak()
//            kClass == ChargedWeakForce::class       -> ChargedWeakForce()
//            kClass == Charm::class                  -> Charm()
//            kClass == ChromoCharge::class           -> ChromoCharge()
//            kClass == Color::class                  -> Color()
//            kClass == ColorCharges::class           -> ColorCharges()
//            kClass == Composition::class            -> Composition()
//            kClass == Compound::class               -> Compound()
//            kClass == CRLFTerminatedColor::class    -> CRLFTerminatedColor()
//            kClass == CRLFTerminatedMomentum::class -> CRLFTerminatedMomentum()
//            kClass == CrLfTerminatedString::class   -> CrLfTerminatedString()
//            kClass == DeviceInput::class            -> DeviceInput()
//            kClass == Diatomic::class               -> Diatomic()
//            kClass == Down::class                   -> Down()
//            kClass == Electron::class               -> Electron()
//            kClass == ElectronPositron::class       -> ElectronPositron()
//            kClass == EventHorizon::class           -> EventHorizon()
//            kClass == Fundamentals::class           -> Fundamentals()
//            kClass == Gluon::class                  -> Gluon()
//            kClass == Graviton::class               -> Graviton()
//            kClass == Gravity::class                -> Gravity()
//            kClass == Green::class                  -> Green()
//            kClass == Green_AntiBlue::class         -> Green_AntiBlue()
//            kClass == Green_AntiGreen::class        -> Green_AntiGreen()
//            kClass == Green_AntiRed::class          -> Green_AntiRed()
//            kClass == Hadron::class                 -> Hadron()
//            kClass == Helium::class                 -> Helium()
//            kClass == Host::class                   -> Host()
//            kClass == Hydrogen::class               -> Hydrogen()
//            kClass == HiggsField::class             -> HiggsField()
//            kClass == Higgs::class                  -> Higgs()
//            kClass == Ion::class                    -> Ion()
//            kClass == Kaon::class                   -> Kaon()
//            kClass == KeyValue::class               -> KeyValue()
//            kClass == Lepton::class                 -> Lepton()
//            kClass == LeptonPair::class             -> LeptonPair()
//            kClass == LowerCase::class              -> LowerCase()
//            kClass == Magnetism::class              -> Magnetism()
//            kClass == Material::class               -> Material()
//            kClass == Matter::class                 -> Matter()
//            kClass == Message::class                -> Message()
//            kClass == Metal::class                  -> Metal()
//            kClass == MinusPion::class              -> MinusPion()
//            kClass == Mixture::class                -> Mixture()
//            kClass == Molecular::class              -> Molecular()
//            kClass == Molecule::class               -> Molecule()
//            kClass == Monad::class                  -> Monad()
//            kClass == Muon::class                   -> Muon()
//            kClass == MuonNeutrino::class           -> MuonNeutrino()
//            kClass == Neutrino::class               -> Neutrino()
//            kClass == Neutron::class                -> Neutron()
//            kClass == Neutrons::class               -> Neutrons()
//            kClass == NeutralDownPion::class        -> NeutralDownPion()
//            kClass == NeutralUpPion::class          -> NeutralUpPion()
//            kClass == Nucleons::class               -> Nucleons()
//            kClass == Numbers::class                -> Numbers()
//            kClass == Orbitals::class               -> Orbitals()
//            kClass == Outlet::class                 -> Outlet()
//            kClass == Particle::class               -> Particle()
//            kClass == ParticleBeam::class           -> ParticleBeam()
//            kClass == PasswordFld::class            -> PasswordFld()
//            kClass == Path::class                   -> Path()
//            kClass == Photon::class                 -> Photon()
//            kClass == Proton::class                 -> Proton()
//            kClass == Protons::class                -> Protons()
//            kClass == QuarkValue::class             -> QuarkValue()
//            kClass == QBoolean::class               -> QBoolean()
//            kClass == QByte::class                  -> QByte()
//            kClass == QCD::class                    -> QCD()
//            kClass == QDouble::class                -> QDouble()
//            kClass == QInt::class                   -> QInt()
//            kClass == QString::class                -> QString()
//            kClass == QMass::class                  -> QMass()
//            kClass == Quark::class                  -> Quark()
//            kClass == Red::class                    -> Red()
//            kClass == Red_AntiBlue::class           -> Red_AntiBlue()
//            kClass == Red_AntiBlue::class           -> Red_AntiBlue()
//            kClass == Red_AntiRed::class            -> Red_AntiRed()
//            kClass == SocketMessage::class          -> SocketMessage()
//            kClass == Solution::class               -> Solution()
//            kClass == Spin::class                   -> Spin()
//            kClass == Strange::class                -> Strange()
//            kClass == Strobe::class                 -> Strobe()
//            kClass == Strong::class                 -> Strong()
//            kClass == Tau::class                    -> Tau()
//            kClass == TauNeutrino::class            -> TauNeutrino()
//            kClass == Time::class                   -> Time()
//            kClass == Top::class                    -> Top()
//            kClass == Universe::class               -> Universe()
//            kClass == Up::class                     -> Up()
//            kClass == UpperCase::class              -> UpperCase()
//            kClass == UseridFld::class              -> UseridFld()
//            kClass == Wavelength::class             -> Wavelength()
//            kClass == WBosonMinus::class            -> WBosonMinus()
//            kClass == WBosonPlus::class             -> WBosonPlus()
//            kClass == ZBoson::class                 -> ZBoson()
//            /*****************/
//            kClass == AppendMSG::class              -> AppendMSG()
//            kClass == BackgroundColor::class        -> BackgroundColor()
//            kClass == Body::class                   -> Body()
//            kClass == Dom::class                    -> Dom()
//            kClass == DomHeight::class              -> DomHeight()
//            kClass == DomId::class                  -> DomId()
//            kClass == DomLeft::class                -> DomLeft()
//            kClass == DomProperties::class          -> DomProperties()
//            kClass == DomProperty::class            -> DomProperty()
//            kClass == DomStyle::class               -> DomStyle()
//            kClass == DomTop::class                 -> DomTop()
//            kClass == DomWidth::class               -> DomWidth()
//            kClass == HtmlPeer::class               -> HtmlPeer()
//            kClass == LoginMSG::class               -> LoginMSG()
//            kClass == ReadyMSG::class               -> ReadyMSG()
//            else                                    -> null
//        }
//        return result
//    }

}

