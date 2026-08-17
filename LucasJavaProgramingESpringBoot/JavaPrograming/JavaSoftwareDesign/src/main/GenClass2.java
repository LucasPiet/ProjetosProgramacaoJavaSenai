package main;

public class GenClass2 <Type1,Type2>{

        private Type1 key;
        private Type2 description;

        public GenClass2(){

        }
        public GenClass2 (Type1 key,Type2 description){
            this.description = description;
            this.key = key;

        }
        public Type1 getKey(){

            return key;

        }


    public Type2 getDescription() {
        return description;
    }

    public void setDescription(Type2 description) {
        this.description = description;
    }

    public void setKey(Type1 key){

            this.key = key;

        }
}


