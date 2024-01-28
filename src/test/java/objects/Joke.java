package objects;

public class Joke {

    private Boolean error;
    private String category;
    private String type;
    private String setup;
    private String delivery;
    private Flags flags;
    private Integer id;
    private Boolean safe;
    private String lang;

    public Joke() {
    }


    public Joke(Boolean error, String category, String type, String setup, String delivery, Flags flags, Integer id, Boolean safe, String lang) {
        super();
        this.error = error;
        this.category = category;
        this.type = type;
        this.setup = setup;
        this.delivery = delivery;
        this.flags = flags;
        this.id = id;
        this.safe = safe;
        this.lang = lang;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSetup() {
        return setup;
    }

    public void setSetup(String setup) {
        this.setup = setup;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public Flags getFlags() {
        return flags;
    }

    public void setFlags(Flags flags) {
        this.flags = flags;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getSafe() {
        return safe;
    }

    public void setSafe(Boolean safe) {
        this.safe = safe;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public String toString() {
        return
                "category = '" + category + '\'' +
                        "\ntype = '" + type + '\'' +
                        "\nsetup = '" + setup + '\'' +
                        "\ndelivery = '" + delivery + '\'' +
                        "\nflags = {" + flags
                        +" }";
    }


    public class Flags {

        private Boolean nsfw;
        private Boolean religious;
        private Boolean political;
        private Boolean racist;
        private Boolean sexist;
        private Boolean explicit;

        public Flags() {
        }

        public Flags(Boolean nsfw, Boolean religious, Boolean political, Boolean racist, Boolean sexist, Boolean explicit) {
            super();
            this.nsfw = nsfw;
            this.religious = religious;
            this.political = political;
            this.racist = racist;
            this.sexist = sexist;
            this.explicit = explicit;
        }

        public Boolean getNsfw() {
            return nsfw;
        }

        public void setNsfw(Boolean nsfw) {
            this.nsfw = nsfw;
        }

        public Boolean getReligious() {
            return religious;
        }

        public void setReligious(Boolean religious) {
            this.religious = religious;
        }

        public Boolean getPolitical() {
            return political;
        }

        public void setPolitical(Boolean political) {
            this.political = political;
        }

        public Boolean getRacist() {
            return racist;
        }

        public void setRacist(Boolean racist) {
            this.racist = racist;
        }

        public Boolean getSexist() {
            return sexist;
        }

        public void setSexist(Boolean sexist) {
            this.sexist = sexist;
        }

        public Boolean getExplicit() {
            return explicit;
        }

        public void setExplicit(Boolean explicit) {
            this.explicit = explicit;
        }

        @Override
        public String toString() {
            return
                    "\n   nsfw = " + nsfw +
                    "\n   religious = " + religious +
                    "\n   political = " + political +
                    "\n   racist = " + racist +
                    "\n   sexist = " + sexist +
                    "\n   explicit = " + explicit;
        }
    }

}