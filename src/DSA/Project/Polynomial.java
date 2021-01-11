package DSA.Project;

public class Polynomial{

    int degree;
    int [][] coef_exp;

    public Polynomial(int degree){
        this.degree = degree;
        this.coef_exp = new int [degree][degree];
    }

    public void setCoef_exp(int [][]NewCoef_exp) throws Exception {
        coef_exp = NewCoef_exp;
    }

    public Polynomial sum(Polynomial that_poly){
        int i=0,j=0,k=0;

        Polynomial  result = new Polynomial(this.degree);


            while(this.coef_exp[0].length > i && that_poly.coef_exp[0].length >j ) {

                if (this.coef_exp[1][i] == that_poly.coef_exp[1][j]) {
                    result.coef_exp[0][k] = this.coef_exp[0][i] + that_poly.coef_exp[0][j];
                    result.coef_exp[1][k] = this.coef_exp[1][i];
                    k++;
                    i++;
                    j++;

                } else if (this.coef_exp[1][i] > that_poly.coef_exp[1][j]) {

                    result.coef_exp[0][k] = this.coef_exp[0][i];
                    result.coef_exp[1][k] = this.coef_exp[1][i];
                    k++;
                    i++;

                } else if (this.coef_exp[1][i] < that_poly.coef_exp[1][j]) {

                    result.coef_exp[0][k] = that_poly.coef_exp[0][j];
                    result.coef_exp[1][k] = that_poly.coef_exp[1][j];
                    k++;
                    j++;
                }
            }

            while(i<this.coef_exp[0].length){
                result.coef_exp[0][k]=this.coef_exp[0][i];
                result.coef_exp[1][k]=this.coef_exp[1][i];

                i++;
                k++;
            }

            while(j<that_poly.coef_exp[0].length){
                result.coef_exp[0][k]=that_poly.coef_exp[0][j];
                result.coef_exp[1][k]=that_poly.coef_exp[1][j];
                j++;
                k++;
            }


        return result;
    }

    @Override
    public String toString(){
        StringBuilder Normilized_Polynomial = new StringBuilder();

        for(int i=0;i<this.coef_exp[1].length;i++){

            if(this.coef_exp[1][i]==1){
                Normilized_Polynomial.append(String.format("%dX ", coef_exp[0][i]));
            }

            else {

                Normilized_Polynomial.append(String.format(" %dX^%d + ", coef_exp[0][i], coef_exp[1][i]));
            }
        }
        return Normilized_Polynomial.toString();
    }

    public static void main(String[] args) throws Exception {
        Polynomial poly1 = new Polynomial(4);
        Polynomial poly2 = new Polynomial(4);
        int [][] zarib_tavan = {{6,9,1},{4,2,1}};
        int [][] zarib_tavan2 = {{6,5,1},{4,3,1}};
        poly1.setCoef_exp(zarib_tavan);
        poly2.setCoef_exp(zarib_tavan2);
        System.out.println(poly1.sum(poly2));
    }
        }