package com.lypgod.test.tij4.practices.Ch19_EnumeratedTypes.Practice9;


import com.lypgod.test.tij4.practices.Ch19_EnumeratedTypes.Enums;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

interface Handler {
    boolean handle(Mail m);
} // Command design pattern

class Mail {
    static long counter = 0;
    GeneralDelivery generalDelivery;
    Scannability scannability;
    Readability readability;
    Address address;
    ReturnAddress returnAddress;
    long id = counter++;

    // Generate test Mail:
    public static Mail randomMail() {
        Mail m = new Mail();
        m.generalDelivery = Enums.random(GeneralDelivery.class);
        m.scannability = Enums.random(Scannability.class);
        m.readability = Enums.random(Readability.class);
        m.address = Enums.random(Address.class);
        m.returnAddress = Enums.random(ReturnAddress.class);
        return m;
    }

    public static Iterable<Mail> generator(final int count) {
        return new Iterable<Mail>() {
            int n = count;

            public Iterator<Mail> iterator() {
                return new Iterator<Mail>() {
                    public boolean hasNext() {
                        return n-- > 0;
                    }

                    public Mail next() {
                        return randomMail();
                    }

                    public void remove() { // not implemented
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }

    public String toString() {
        return "Mail " + id;
    }

    public String details() {
        return toString() + ", General Delivery: " + generalDelivery + ", Address Scannability: " + scannability + ", Address Readability: " + readability + ", Address Address: " + address + ", Return address: " + returnAddress;
    }
    // The NO's lower the probability of random selection:
    enum GeneralDelivery {
        YES, NO1, NO2, NO3, NO4, NO5
    }

    enum Scannability {UNSCANNABLE, YES1, YES2, YES3, YES4}

    enum Readability {ILLEGIBLE, YES1, YES2, YES3, YES4}

    enum Address {INCORRECT, OK1, OK2, OK3, OK4, OK5, OK6}

    enum ReturnAddress {MISSING, OK1, OK2, OK3, OK4, OK5}
}

public class PostOffice {
    public static void handle(Mail m, EnumMap<MailHandler, Handler> em) {
        for (Map.Entry<MailHandler, Handler> e : em.entrySet()) {
            if (e.getValue().handle(m))
                return;
        }
        System.out.println(m + " is a dead letter");
    }

    public static void main(String[] args) {
        EnumMap<MailHandler, Handler> em = new EnumMap<>(MailHandler.class);
        em.put(MailHandler.GENERAL_DELIVERY, new Handler() {
            public boolean handle(Mail m) {
                switch (m.generalDelivery) {
                    case YES:
                        System.out.println("Using general delivery for " + m);
                        return true;
                    default:
                        return false;
                }
            }
        });
        em.put(MailHandler.MACHINE_SCAN, new Handler() {
            public boolean handle(Mail m) {
                switch (m.scannability) {
                    case UNSCANNABLE:
                        return false;
                    default:
                        switch (m.address) {
                            case INCORRECT:
                                return false;
                            default:
                                System.out.println("Delivering " + m + " automatically");
                                return true;
                        }
                }
            }
        });
        em.put(MailHandler.VISUAL_INSPECTION, new Handler() {
            public boolean handle(Mail m) {
                switch (m.readability) {
                    case ILLEGIBLE:
                        return false;
                    default:
                        switch (m.address) {
                            case INCORRECT:
                                return false;
                            default:
                                System.out.println("Delivering " + m + " normally");
                                return true;
                        }
                }
            }
        });
        em.put(MailHandler.RETURN_TO_SENDER, new Handler() {
            public boolean handle(Mail m) {
                switch (m.returnAddress) {
                    case MISSING:
                        return false;
                    default:
                        System.out.println("Return " + m + " to sender");
                        return true;
                }
            }
        });
        for (Mail mail : Mail.generator(10)) {
            System.out.println(mail.details());
            handle(mail, em);
            System.out.println("*****");
        }
    }

    enum MailHandler {GENERAL_DELIVERY, MACHINE_SCAN, VISUAL_INSPECTION, RETURN_TO_SENDER}
}
