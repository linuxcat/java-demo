require 'dockerspec/serverspec'

describe docker_compose('docker-compose-dev.yml', wait: 30, rm: true) do

  its_container(:database) do
    describe port(5432) do
      it { should be_listening('tcp') }
    end

    describe file('/usr/share/postgresql/9.6/postgresql.conf') do
      it { should exist }
    end

  end

end