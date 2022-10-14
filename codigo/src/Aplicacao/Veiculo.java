package Aplicacao;

public class Veiculo {

    private static final String TIPO_VEICULO_01 = "carro", TIPO_VEICULO_02 = "van", TIPO_VEICULO_03 = "furgão",
            TIPO_VEICULO_04 = "caminhão";
    private static final int PERCENTUAL_IPVA_V01 = 4, PERCENTUAL_IPVA_V02 = 3, PERCENTUAL_IPVA_V03 = 3,
            PERCENTUAL_IPVA_V04 = 1,
            PERCENTUAL_SEGURO_V01 = 5, PERCENTUAL_SEGURO_V02 = 3, PERCENTUAL_SEGURO_V03 = 3, PERCENTUAL_SEGURO_V04 = 2,
            CAPACIDADE_TANQUE_V01 = 50, CAPACIDADE_TANQUE_V02 = 60, CAPACIDADE_TANQUE_V03 = 80,
            CAPACIDADE_TANQUE_V04 = 250;
    private static final double ACRESCIMO_SEGURO_V01 = 300.00, ACRESCIMO_SEGURO_V02 = 0.00, ACRESCIMO_SEGURO_V03 = 0.00,
            ACRESCIMO_SEGURO_V04 = 2000.00;
  
    private String tipoVeiculo, placa;
    private int percentualIpva, percentualSeguro, capacidadeTanque;
    private double valorVenda, acrescimoSeguro, kmPorLitro;

    public Veiculo(String placa, String tipoVeiculo) {
        this.placa = placa;
        this.tipoVeiculo = tipoVeiculo;
    }

    private float percentualIpva(String tipoVeiculo) {
        if (tipoVeiculo == TIPO_VEICULO_01) {
            percentualIpva = PERCENTUAL_IPVA_V01;
        } else {
            if (tipoVeiculo == TIPO_VEICULO_02) {
                percentualIpva = PERCENTUAL_IPVA_V02;
            } else {
                if (tipoVeiculo == TIPO_VEICULO_03) {
                    percentualIpva = PERCENTUAL_IPVA_V03;
                } else {
                    if (tipoVeiculo == TIPO_VEICULO_04) {
                        percentualIpva = PERCENTUAL_IPVA_V04;
                    } else {
                        System.out.println("Tipo de veículo inexistente");
                    }
                }
            }
        }
        return percentualIpva;
    }

    private float percentualSeguro(String tipoVeiculo) {
        if (tipoVeiculo == TIPO_VEICULO_01) {
            percentualSeguro = PERCENTUAL_SEGURO_V01;
        } else {
            if (tipoVeiculo == TIPO_VEICULO_02) {
                percentualSeguro = PERCENTUAL_SEGURO_V02;
            } else {
                if (tipoVeiculo == TIPO_VEICULO_03) {
                    percentualSeguro = PERCENTUAL_SEGURO_V03;
                } else {
                    if (tipoVeiculo == TIPO_VEICULO_04) {
                        percentualSeguro = PERCENTUAL_SEGURO_V04;
                    } else {
                        System.out.println("Tipo de veículo inexistente");
                    }
                }
            }
        }
        return percentualSeguro;
    }

    private float acrescimoSeguro(String tipoVeiculo) {
        if (tipoVeiculo == TIPO_VEICULO_01) {
            acrescimoSeguro = ACRESCIMO_SEGURO_V01;
        } else {
            if (tipoVeiculo == TIPO_VEICULO_02) {
                acrescimoSeguro = ACRESCIMO_SEGURO_V02;
            } else {
                if (tipoVeiculo == TIPO_VEICULO_03) {
                    acrescimoSeguro = ACRESCIMO_SEGURO_V03;
                } else {
                    if (tipoVeiculo == TIPO_VEICULO_04) {
                        acrescimoSeguro = ACRESCIMO_SEGURO_V04;
                    } else {
                        System.out.println("Tipo de veículo inexistente");
                    }
                }
            }
        }
        return percentualIpva;
    }

    private int capacidadeTanque(String tipoVeiculo) {
        if (tipoVeiculo == TIPO_VEICULO_01) {
            capacidadeTanque = CAPACIDADE_TANQUE_V01;
        } else {
            if (tipoVeiculo == TIPO_VEICULO_02) {
                capacidadeTanque = CAPACIDADE_TANQUE_V02;
            } else {
                if (tipoVeiculo == TIPO_VEICULO_03) {
                    capacidadeTanque = CAPACIDADE_TANQUE_V03;
                } else {
                    if (tipoVeiculo == TIPO_VEICULO_04) {
                        capacidadeTanque = CAPACIDADE_TANQUE_V04;
                    } else {
                        System.out.println("Tipo de veículo inexistente");
                    }
                }
            }
        }
        return capacidadeTanque;
    }

    public float valorIpva(float valorVenda, String tipoVeiculo) {
        return (valorVenda * percentualIpva(tipoVeiculo));
    }

    public float valorSeguro(float valorVenda, String tipoVeiculo) {
        return (valorVenda * percentualSeguro() / 100 + acrescimoSeguro());
    }

    public float autonomia(float kmPorLitro, int capacidadeTanque) {
        return (kmPorLitro * capacidadeTanque);
    }

    // public outrosCustos(){

    // }

}
