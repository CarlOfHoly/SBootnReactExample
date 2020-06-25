import React, { useState } from 'react'
import './Group.css'
import { SkjemaGruppe, Input, Select } from 'nav-frontend-skjema';
import { Knapp } from 'nav-frontend-knapper';
import AxiosInstance from './AxiosInstance';

interface Props {

}

export const Group: React.FC<Props> = () => {
    
    const [group, setGroup] = useState({
        group: '',
        likesIceCream: ''
    })
    const [timeForIce, setTimeForIce] = useState(null)

    const handleChange = (e: { target: { name: any; value: any; }; }) => {
        setGroup({...group, [e.target.name]: e.target.value})
        console.log(group)
    }

    const handleSubmit = (e: { preventDefault: () => void; }) => {
        e.preventDefault()
        AxiosInstance.post('/tidforis', group)
        .then(res => (setTimeForIce(res.data.timeForIceCream)))
    }
    const iceTime = (
        <div>
            {group.group} skal ha is: {timeForIce}
        </div>
    )
        return (
            <div>
                <SkjemaGruppe legend="Er det tid for is?">
                    <Input label="Gruppe" name="group" onChange={handleChange}/>
                    <Select label="Lyst på is?" name="likesIceCream" onChange={handleChange}>
                        <option value="true">True</option>
                        <option value="fasle">False</option>
                    </Select>
                    <Knapp onClick={handleSubmit}>Send inn!</Knapp>
                </SkjemaGruppe>
                <p>
                {timeForIce ? iceTime : null}
                </p>
            </div>
        );
}